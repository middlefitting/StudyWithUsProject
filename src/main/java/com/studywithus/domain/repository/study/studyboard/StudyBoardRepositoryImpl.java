package com.studywithus.domain.repository.study.studyboard;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class StudyBoardRepositoryImpl implements StudyBoardRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public StudyBoardRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
