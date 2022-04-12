package com.studywithus.domain.repository.study.studyboardcommentrecommend;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class StudyBoardCommentRecommendRepositoryImpl implements StudyBoardCommentRecommendRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public StudyBoardCommentRecommendRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

}
