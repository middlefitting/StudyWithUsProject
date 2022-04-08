package com.studywithus.repository.study.Study;

import com.studywithus.domain.study.Study;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class StudyRepositoryImpl extends QuerydslRepositorySupport implements StudyRepositoryCustom {

    public StudyRepositoryImpl() {
        super(Study.class);
    }
}
