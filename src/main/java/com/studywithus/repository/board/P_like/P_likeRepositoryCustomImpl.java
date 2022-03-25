package com.studywithus.repository.board.P_like;

import com.studywithus.domain.board.P_like;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class P_likeRepositoryCustomImpl extends QuerydslRepositorySupport implements P_likeRepositoryCustom {

    public P_likeRepositoryCustomImpl() {
        super(P_like.class);
    }
}
