package com.studywithus.domain.repository.board.P_like;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import com.studywithus.domain.entity.board.P_like;
import com.studywithus.domain.entity.board.QP_like;
import com.studywithus.domain.entity.board.QPost;
import com.studywithus.domain.entity.member.QMember;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class P_likeRepositoryImpl extends QuerydslRepositorySupport implements P_likeRepositoryCustom {

    public P_likeRepositoryImpl() {
        super(P_like.class);
    }

    QPost post = QPost.post;
    QMember member = QMember.member;
    QP_like p_like = QP_like.p_like;

    @Override
    public List<Tuple> getP_like(Long post_id) {
        JPQLQuery<P_like> jpqlQuery = from(p_like);
        jpqlQuery.leftJoin(member).on(p_like.mem_id.eq(member));
        JPQLQuery<Tuple> tuple = jpqlQuery.select(p_like, member);
        tuple.where(p_like.post_id.eq(post_id));
        return tuple.fetch();
    }
}
