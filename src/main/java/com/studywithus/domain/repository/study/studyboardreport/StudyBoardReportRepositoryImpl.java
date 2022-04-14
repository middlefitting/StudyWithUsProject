package com.studywithus.domain.repository.study.studyboardreport;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class StudyBoardReportRepositoryImpl implements StudyBoardReportRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public StudyBoardReportRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

}
