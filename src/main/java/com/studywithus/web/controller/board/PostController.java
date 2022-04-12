package com.studywithus.web.controller.board;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.studywithus.config.jwt.JwtProperties;
import com.studywithus.domain.entity.board.Comment;
import com.studywithus.domain.repository.search.SearchRepository;
import com.studywithus.domain.service.board.CommentService;
import com.studywithus.domain.service.board.P_likeService;
import com.studywithus.web.controller.board.dto.*;
import com.studywithus.domain.service.board.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
//@RequestMapping("/api")
public class PostController {

    private final PostService postService;
    private final CommentService commentService;
    private final P_likeService p_likeService;

    // 1. Create
    // 글 등록
    @PostMapping("/board/register")
    public CreatePostResponseDto registerPost(@RequestBody @Valid PostDto requestDto){
        Long id = postService.register(requestDto);
        CreatePostResponseDto responseDto = new CreatePostResponseDto(id);
        return responseDto;
    }

    // 2. Read
    // 전체 게시글 조회 (카테고리)
    private int page;
    private int size;
    @GetMapping("/board")
    public  PageResultDTO<PostDto, Object[]> getList(
            @RequestParam("category") String category,
            @RequestParam("page") int page) {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        pageRequestDTO.setCategory(category);
        pageRequestDTO.setPage(page);

        return postService.getList(pageRequestDTO);
    }

    // 검색 게시글 조회
    @GetMapping("/board/search/{keyword}")
    public PageResultDTO<PostDto, Object[]> getSearchList(
            @RequestParam("type") String type,
            @PathVariable("keyword") String keyword) {
        SearchPageRequestDTO pageRequestDTO = new SearchPageRequestDTO();
        pageRequestDTO.setType(type);
        pageRequestDTO.setKeyword(keyword);

        return postService.getSearchList(pageRequestDTO);
    }

//    // 세부 게시글 조회
//    @GetMapping("/board/{post_id}")
//    public List<PostDto> getPostDetail(@PathVariable("post_id") Long post_id) {
//       return postService.get(post_id);
//    }

    // 세부 게시글 조회
    @GetMapping("/board/{post_id}")
    public PostAndCommentListDTO getPostDetail(@PathVariable("post_id") Long post_id) {
        ArrayList<PostDto> postDto = postService.get(post_id);
        ArrayList<CommentDto> commentsList = commentService.getList(post_id);

        ArrayList<Object> likeInfo = p_likeService.getListAndCount(post_id);
        ArrayList<P_likeDto> likesList = (ArrayList<P_likeDto>) likeInfo.get(0);
        int likeCnt = (int) likeInfo.get(1);

        PostAndCommentListDTO aa = new PostAndCommentListDTO(postDto, commentsList, likesList, likeCnt);
        return new PostAndCommentListDTO(postDto, commentsList, likesList, likeCnt);
//        ArrayList arr = new ArrayList();
//        arr.add(postDto);
//        arr.add(commentsList);
//        return arr;
    }

    // 3. Update
    // 게시글 수정 화면
    @GetMapping("/board/edit/{post_id}")
    public List<PostDto> modifyPostDetail(@PathVariable("post_id") Long post_id) {
        return postService.get(post_id);
    }

    // 게시글 수정
    @PostMapping("/board/edit/{post_id}")
    public Long modifyPostDetail(
            HttpServletRequest request,
            @PathVariable("post_id") Long post_id,
            @RequestBody @Valid PostDto requestDto) {
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        String id = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken).getClaim("id").asString();

        // 작성자가 아니면 exception 발생
        if(!Objects.equals(id, String.valueOf(requestDto.getWriter_id()))){
            throw new RuntimeException();
        }
        return postService.modify(requestDto);
    }

    // 3. delete
    // 게시글 삭제
    @PostMapping("/board/delete/{post_id}")
    public Long deletePost(@PathVariable("post_id") Long post_id) {
        return postService.remove(post_id);
    }

}
