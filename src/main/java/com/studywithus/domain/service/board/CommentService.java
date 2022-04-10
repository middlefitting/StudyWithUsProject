package com.studywithus.domain.service.board;

import com.studywithus.domain.entity.board.Comment;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.web.controller.board.dto.CommentDto;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface CommentService {
    Long register(CommentDto commentDto);
    ArrayList<CommentDto> getList(@Param("post_id") Long post_id);
    void remove(Long comment_id);

    default Comment dtoToEntity(CommentDto dto) {
        Member member = Member.builder().id(dto.getWriter_id()).build();
        Comment comment = Comment.builder()
                .comment_id(dto.getComment_id())
                .post_id(dto.getPost_id())
                .mem_id(member)
                .content(dto.getContent())
                .build();
        return comment;
    }

    default CommentDto entityToDto(Comment comment, Member member) {
        CommentDto commentDto = CommentDto.builder()
                .comment_id(comment.getComment_id())
                .post_id(comment.getPost_id())
                .writer_id(member.getId())
                .writer_nickname(member.getNickname())
                .content(comment.getContent())
                .modDate(comment.getModDate())
                .regDate(comment.getRegDate())
                .build();
        return commentDto;
    }
}
