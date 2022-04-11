package com.studywithus.domain.service.board;

import com.studywithus.domain.entity.board.C_like;
import com.studywithus.domain.entity.board.Comment;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.web.controller.board.dto.C_likeDto;

public interface C_likeService {
    // Delete
    Long remove(Long like_id);

    default C_like dtoToEntity(C_likeDto c_likeDto) {
        Comment comment = Comment.builder().comment_id(c_likeDto.getComment_id()).build();
        Member member = Member.builder().id(c_likeDto.getWriter_id()).build();
        C_like c_like = C_like.builder()
                .like_id(c_likeDto.getLike_id())
                .comment_id(comment)
                .mem_id(member)
                .build();
        return c_like;
    }

    default C_likeDto entityToDto(C_like c_like, Comment comment, Member member) {
        C_likeDto c_likeDto = C_likeDto.builder()
                .like_id(c_like.getLike_id())
                .comment_id(comment.getComment_id())
                .writer_id(member.getId())
                .writer_nickname(member.getNickname())
                .regDate(c_like.getRegDate())
                .modDate(c_like.getModDate())
                .build();
        return c_likeDto;
    }
}
