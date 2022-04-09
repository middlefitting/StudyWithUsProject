package com.studywithus.web.controller.board;

import com.studywithus.web.controller.board.dto.CreatePostResponseDto;
import com.studywithus.web.controller.board.dto.PageRequestDTO;
import com.studywithus.web.controller.board.dto.PageResultDTO;
import com.studywithus.web.controller.board.dto.PostDto;
import com.studywithus.domain.service.board.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

//@RequestMapping("/board/")
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

    @GetMapping("/board/notice")
    public void getList() {
        System.out.println("hi");
    }

    @PostMapping("/board/notice")
    public ArrayList<PostDto> postList(PageRequestDTO pageRequestDTO) {
        System.out.println("hi");
        PageResultDTO<PostDto, Object[]> result = postService.getList("notice", pageRequestDTO);
        ArrayList<PostDto> arr = new ArrayList<PostDto>(result.getDtoList());
        System.out.println(arr);
        return arr;
    }




}
