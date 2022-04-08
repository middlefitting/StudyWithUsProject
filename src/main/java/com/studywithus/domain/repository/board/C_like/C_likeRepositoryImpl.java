package com.studywithus.domain.repository.board.C_like;

import com.studywithus.domain.entity.board.C_like;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class C_likeRepositoryImpl extends QuerydslRepositorySupport implements C_likeRepositoryCustom {

    public C_likeRepositoryImpl() {
        super(C_like.class);
    }
}
