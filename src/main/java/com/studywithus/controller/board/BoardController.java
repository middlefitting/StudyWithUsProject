package com.studywithus.controller.board;

import com.studywithus.domain.entity.board.Post;
import com.studywithus.dto.board.post.PostSaveRequestDto;
import com.studywithus.service.board.PostService;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final PostService postService;

    // C
    @PostMapping("/post")
    public Long createPost(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        return postService.createPost(postSaveRequestDto);
    }

    // R - One - Nickname

    // R - Each - Title

    // R - All
    @GetMapping("/post")
    public List<Post> getAllPosts() {
        return postService.getAllPost();
    }

    // U

    // D
}
