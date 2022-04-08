package com.studywithus.domain.repository.study.MemStudy;

import com.studywithus.domain.entity.study.MemStudy;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MemStudyRepositoryImpl extends QuerydslRepositorySupport implements MemStudyRepositoryCustom {

    public MemStudyRepositoryImpl() {
        super(MemStudy.class);
    }
}
