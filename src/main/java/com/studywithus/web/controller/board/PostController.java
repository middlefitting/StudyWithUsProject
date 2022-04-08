package com.studywithus.web.controller.board;

import com.studywithus.web.controller.board.dto.CreatePostResponseDto;
import com.studywithus.web.controller.board.dto.PageRequestDTO;
import com.studywithus.web.controller.board.dto.PageResultDTO;
import com.studywithus.web.controller.board.dto.PostDto;
import com.studywithus.domain.service.board.PostService;
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

//    @GetMapping("/board/notice")
//    public ArrayList<PostDto> postList(PageRequestDTO pageRequestDTO) {
//        PageResultDTO<PostDto, Object[]> result = postService.getList("notice", pageRequestDTO);
//        ArrayList<PostDto> arr = new ArrayList<PostDto>(result.getDtoList());
//        System.out.println(arr);
//        return arr;
//    }
    @GetMapping("/board/notice")
    public void postList(PageRequestDTO pageRequestDTO, Model model) {
        model.addAttribute("result", postService.getList("notice", pageRequestDTO));
        System.out.println("================컨트롤러 postService.getList=================");
        System.out.println(postService.getList("notice", pageRequestDTO));
        System.out.println("=================================");
    }




}
