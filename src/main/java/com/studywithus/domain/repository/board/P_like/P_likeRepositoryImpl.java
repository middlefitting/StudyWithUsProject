package com.studywithus.domain.repository.board.P_like;

import com.studywithus.domain.entity.board.P_like;
import com.studywithus.domain.entity.board.QP_like;
import com.studywithus.domain.entity.board.QPost;
import com.studywithus.domain.entity.member.QMember;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class P_likeRepositoryImpl extends QuerydslRepositorySupport implements P_likeRepositoryCustom {
    public P_likeRepositoryImpl() {
        super(P_like.class);
    }

    QP_like qp_like = QP_like.p_like;
    QPost qPost = QPost.post;
    QMember qMember = QMember.member;

    // Delete
    @Override
    public void deleteByPLikeId(Long like_id) {
        delete(qp_like).where(qp_like.like_id.eq(like_id)).execute();
    }
}
