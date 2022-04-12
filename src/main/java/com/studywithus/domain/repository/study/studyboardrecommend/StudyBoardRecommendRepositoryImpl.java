package com.studywithus.domain.repository.study.studyboardrecommend;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class StudyBoardRecommendRepositoryImpl implements StudyBoardRecommendRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public StudyBoardRecommendRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

}
