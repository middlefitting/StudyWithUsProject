package com.studywithus.domain.repository.study.studyboardcomment;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class StudyBoardCommentRepositoryImpl implements StudyBoardCommentRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public StudyBoardCommentRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

}
