package com.studywithus.domain.service.board;

import com.studywithus.domain.entity.board.P_like;
import com.studywithus.domain.entity.board.Post;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.web.controller.board.dto.P_likeDto;

public interface P_likeService {
    // Delete
    Long remove(Long like_id);

    default P_like dtoToEntity(P_likeDto p_likeDto) {
        Post post = Post.builder().post_id(p_likeDto.getPost_id()).build();
        Member member = Member.builder().id(p_likeDto.getWriter_id()).build();
        P_like p_like = P_like.builder()
                .like_id(p_likeDto.getLike_id())
                .post_id(post)
                .mem_id(member)
                .build();
        return p_like;
    }

    default P_likeDto entityToDto(P_like p_like, Post post, Member member) {
        P_likeDto p_likeDto = P_likeDto.builder()
                .like_id(p_like.getLike_id())
                .post_id(post.getPost_id())
                .writer_id(member.getId())
                .writer_nickname(member.getNickname())
                .regDate(p_like.getRegDate())
                .modDate(p_like.getModDate())
                .build();
        return p_likeDto;
    }
}
