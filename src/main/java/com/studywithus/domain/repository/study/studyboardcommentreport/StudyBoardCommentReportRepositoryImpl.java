package com.studywithus.domain.repository.study.studyboardcommentreport;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class StudyBoardCommentReportRepositoryImpl implements StudyBoardCommentReportRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public StudyBoardCommentReportRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

}
