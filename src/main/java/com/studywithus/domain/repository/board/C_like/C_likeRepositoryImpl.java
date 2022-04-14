package com.studywithus.domain.repository.board.C_like;

import com.studywithus.domain.entity.board.C_like;
import com.studywithus.domain.entity.board.QC_like;
import com.studywithus.domain.entity.board.QComment;
import com.studywithus.domain.entity.member.QMember;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class C_likeRepositoryImpl extends QuerydslRepositorySupport implements C_likeRepositoryCustom {
    public C_likeRepositoryImpl() {
        super(C_like.class);
    }

    QC_like qc_like = QC_like.c_like;
    QComment qComment = QComment.comment;
    QMember qMember = QMember.member;

    // Delete
    @Override
    public void deleteByCLikeId(Long like_id) {
        delete(qc_like).where(qc_like.like_id.eq(like_id)).execute();
    }
}
