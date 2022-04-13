package com.studywithus.domain.service.board;

import com.querydsl.core.Tuple;
import com.studywithus.domain.repository.board.C_like.C_likeRepository;
import com.studywithus.domain.repository.board.Comment.CommentRepository;
import com.studywithus.domain.repository.board.P_like.P_likeRepository;
import com.studywithus.domain.repository.member.MemberRepository;
import com.studywithus.domain.repository.search.SearchRepository;
import com.studywithus.web.controller.board.dto.PageRequestDTO;
import com.studywithus.web.controller.board.dto.PageResultDTO;
import com.studywithus.web.controller.board.dto.PostDto;
import com.studywithus.domain.entity.board.Post;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.repository.board.Post.PostRepository;
import com.studywithus.web.controller.board.dto.SearchPageRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class PostServiceImpl implements PostService{

    private final PostRepository repository;
    private final CommentRepository commentRepository;
    private final P_likeRepository p_likeRepository;
    private final C_likeRepository c_likeRepository;
    private final SearchRepository searchRepository;
    private final MemberRepository memberRepository;
    private final SearchRepository searchRepository;


    @Override
    public Long register(PostDto postDto) {
        postDto.setViews(0); //default 0
        Post post = dtoToEntity(postDto);
        if (post != null) {
            repository.save(post);
            return post.getPost_id();
        } else {
            return Long.parseLong("-1");
        }

    }

    @Override
    public ArrayList<PostDto> get(Long post_id) {
        System.out.println("지금 get쓰임");
        List<Tuple> result = repository.getPostByPostId(post_id);
        List arr = result.stream().map(t -> t.toArray()).collect(Collectors.toList());
        Function<Object[], PostDto> fn = (en -> entityToDto((Post)en[0], (Member) en[1]));
        ArrayList<PostDto> dtoList = (ArrayList<PostDto>) arr.stream().map(fn).collect(Collectors.toList());

        // 조회수 처리
        int viewplus = dtoList.get(0).getViews() + 1;
        repository.updateViews(post_id, viewplus);

        return dtoList;
    }

    @Override
    public PageResultDTO<PostDto, Object[]> getList(PageRequestDTO pageRequestDTO) {
        Function<Object[], PostDto> fn = (en -> entityToDto((Post)en[0], (Member) en[1]));

        Page<Object[]> result = repository.getPostsByCategory(
                pageRequestDTO.getCategory(),
                pageRequestDTO.getPageable(Sort.by("regDate").descending())
        );
//        System.out.println("==================서비스 result============");
//        System.out.println(result);
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public PageResultDTO<PostDto, Object[]> getSearchList(SearchPageRequestDTO pageRequestDTO) {
        Function<Object[], PostDto> fn = (en -> entityToDto((Post)en[0], (Member) en[1]));

        Page<Object[]> result = searchRepository.searchPage(
                pageRequestDTO.getType(),
                pageRequestDTO.getKeyword(),
                pageRequestDTO.getCategory(),
                pageRequestDTO.getPageable(Sort.by("regDate").descending())
        );
        return new PageResultDTO<>(result, fn);
    }

    @Transactional
    @Override
    public Long remove(Long post_id) {
        //좋아요삭제
        c_likeRepository.deleteByCLikeId(post_id);
//        p_likeRepository.deleteByPLikeId(post_id);
        //댓글삭제
//        commentRepository.deleteByPostId(post_id);
        //글삭제
        repository.deleteByPostId(post_id);
        return post_id;
    }

    @Transactional
    @Override
    public Long modify(PostDto postDto) {
        Post post = repository.getById(postDto.getPost_id());

        post.updatePost(postDto.getTitle(), postDto.getContent(), postDto.getCategory());

        repository.save(post);
        return post.getPost_id();
    }

    @Override
    public Post dtoToEntity(PostDto dto) {

        Member member = memberRepository.findById(dto.getWriter_id()).orElse(null);
        Post post = new Post();

        if (member != null) {
            post = Post.builder()
//                .post_id(dto.getPost_id())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .category(dto.getCategory())
                .views(dto.getViews())
                .build();
//            post.setTitle(dto.getTitle());
//            post.setContent(dto.getContent());
//            post.setWriter(member);
//            post.setCategory(dto.getCategory());
//            post.setViews(dto.getViews());
            repository.save(post);
        }
        return post;
    }

 /*   public Post dtoToEntity(PostDto dto) {
//        Member member = Member.builder().id(dto.getWriter_id()).build();
        Optional<Member> memberOptional = memberRepository.findById(dto.getWriter_id());
        Member member = memberOptional.orElseGet(Member::new);
        if(member.getId()!=null){
            Post post = Post.builder()
                    .post_id(dto.getPost_id())
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .writer(member)
                    .category(dto.getCategory())
                    .views(dto.getViews())
                    .build();
            return post;
        }

        throw new RuntimeException();
    }*/

    public PostDto entityToDto(Post post, Member member) {
        PostDto postDto = PostDto.builder()
                .post_id(post.getPost_id())
                .title(post.getTitle())
                .content(post.getContent())
                .writer_id(member.getId())
                .writer_nickname(member.getNickname())
                .category(post.getCategory())
                .views(post.getViews())
                .modDate(post.getModDate())
                .regDate(post.getRegDate())
                .build();
        return postDto;
    }


}