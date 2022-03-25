package com.studywithus.repository.board.c_like;

import com.studywithus.domain.board.C_like;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class C_likeRepositoryCustomImpl extends QuerydslRepositorySupport implements C_likeRepositoryCustom {

    public C_likeRepositoryCustomImpl() {
        super(C_like.class);
    }
}
