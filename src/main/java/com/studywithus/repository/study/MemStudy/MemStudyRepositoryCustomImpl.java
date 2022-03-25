package com.studywithus.repository.study.MemStudy;

import com.studywithus.domain.study.MemStudy;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MemStudyRepositoryCustomImpl extends QuerydslRepositorySupport implements MemStudyRepositoryCustom {

    public MemStudyRepositoryCustomImpl() {
        super(MemStudy.class);
    }
}
