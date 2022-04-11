package com.studywithus.domain.repository.study.study;

import com.studywithus.domain.entity.study.Study;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class StudyRepositoryImpl extends QuerydslRepositorySupport implements StudyRepositoryCustom {

    public StudyRepositoryImpl() {
        super(Study.class);
    }
}
