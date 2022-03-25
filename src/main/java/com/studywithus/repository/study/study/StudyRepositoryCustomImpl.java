package com.studywithus.repository.study.study;

import com.studywithus.domain.study.Study;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class StudyRepositoryCustomImpl extends QuerydslRepositorySupport implements StudyRepositoryCustom {

    public StudyRepositoryCustomImpl() {
        super(Study.class);
    }
}
