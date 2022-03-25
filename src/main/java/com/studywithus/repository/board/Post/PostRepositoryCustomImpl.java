package com.studywithus.repository.board.Post;

import com.studywithus.domain.board.Post;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class PostRepositoryCustomImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {

    public PostRepositoryCustomImpl() {
        super(Post.class);
    }
}
