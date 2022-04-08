package com.studywithus.domain.repository.board.P_like;

import com.studywithus.domain.entity.board.P_like;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class P_likeRepositoryImpl extends QuerydslRepositorySupport implements P_likeRepositoryCustom {

    public P_likeRepositoryImpl() {
        super(P_like.class);
    }
}
