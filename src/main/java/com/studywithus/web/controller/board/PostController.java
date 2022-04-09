package com.studywithus.web.controller.board;

import com.studywithus.web.controller.board.dto.CreatePostResponseDto;
import com.studywithus.web.controller.board.dto.PageRequestDTO;
import com.studywithus.web.controller.board.dto.PageResultDTO;
import com.studywithus.web.controller.board.dto.PostDto;
import com.studywithus.domain.service.board.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @PostMapping("/board/register")
    public CreatePostResponseDto registerPost(@RequestBody @Valid PostDto requestDto){
//        exception 걸기 필요
        Long id = postService.register(requestDto);
        CreatePostResponseDto responseDto = new CreatePostResponseDto(id);
        return responseDto;
    }

    private int page;
    private int size;
    @GetMapping("/board")
    public  PageResultDTO<PostDto, Object[]> getList(
            @RequestParam("category") String category,
            @RequestParam("page") int page
    ) {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        pageRequestDTO.setCategory(category);
        pageRequestDTO.setPage(page);

//        PageResultDTO<PostDto, Object[]> result = postService.getList(pageRequestDTO);
//        ArrayList<PageResultDTO> arr = new ArrayList<PostDto>(result.getDtoList());
//        System.out.println(arr);
        return postService.getList(pageRequestDTO);
    }
//    @GetMapping("/board/notice")
//    public void postList(PageRequestDTO pageRequestDTO, Model model) {
//        model.addAttribute("result", postService.getList("notice", pageRequestDTO));
//        System.out.println("================컨트롤러 postService.getList=================");///////////////
//        System.out.println(postService.getList("notice", pageRequestDTO));////////////////
//        System.out.println("=================================");////////////////
//    }




}
