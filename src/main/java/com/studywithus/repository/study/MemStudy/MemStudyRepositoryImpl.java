package com.studywithus.repository.study.MemStudy;

import com.studywithus.domain.study.MemStudy;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MemStudyRepositoryImpl extends QuerydslRepositorySupport implements MemStudyRepositoryCustom {

    public MemStudyRepositoryImpl() {
        super(MemStudy.class);
    }
}
