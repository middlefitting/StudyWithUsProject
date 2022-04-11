package com.studywithus.web.controller.board;

import com.studywithus.domain.service.board.CommentService;
import com.studywithus.web.controller.board.dto.CommentDto;
import com.studywithus.web.controller.board.dto.CreatePostResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // comment 등록
    @PostMapping("/comment/register")
    public Long registerComment(@RequestBody @Valid CommentDto requestDto){
        return commentService.register(requestDto);
    }

    // comment 삭제
    @PostMapping("/comment/delete/{comment_id}")
    public void deleteComment(@PathVariable("comment_id") Long comment_id) {
        commentService.remove(comment_id);
    }


}
