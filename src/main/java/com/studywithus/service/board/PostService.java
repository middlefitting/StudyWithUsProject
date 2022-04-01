package com.studywithus.service.board;

import com.studywithus.controller.board.dto.PostDto;
import com.studywithus.domain.board.Post;
import com.studywithus.domain.member.Member;

public interface PostService {
    Long register(PostDto dto);
    default Post dtoToEntity(PostDto dto) {
        Member member = Member.builder().id(dto.getWriter_id()) .build();
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
}
