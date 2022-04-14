package com.studywithus.domain.repository.study.studyboardfiledir;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class StudyBoardFileDirRepositoryImpl implements StudyBoardFileDirRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public StudyBoardFileDirRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

}
