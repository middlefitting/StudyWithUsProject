package com.studywithus.controller.board;

import com.studywithus.controller.board.dto.CreatePostResponseDto;
import com.studywithus.controller.board.dto.PageRequestDTO;
import com.studywithus.controller.board.dto.PageResultDTO;
import com.studywithus.controller.board.dto.PostDto;
import com.studywithus.service.board.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

//@RequestMapping("/board/")
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/board/register")
    public CreatePostResponseDto registerPost(@RequestBody @Valid PostDto requestDto){
//        exception 걸기 필요
        Long id = postService.register(requestDto);
        CreatePostResponseDto responseDto = new CreatePostResponseDto(id);
        return responseDto;
    }

    @PostMapping("/board/notice")
    public ArrayList<PostDto> postList(@RequestParam PageRequestDTO pageRequestDTO) {
        PageResultDTO<PostDto, Object[]> result = postService.getList("notice", pageRequestDTO);
        ArrayList<PostDto> arr = new ArrayList<PostDto>(result.getDtoList());

        return arr;
    }




}
