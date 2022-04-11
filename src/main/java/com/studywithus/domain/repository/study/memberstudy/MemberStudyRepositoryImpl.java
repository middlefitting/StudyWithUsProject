package com.studywithus.domain.repository.study.memberstudy;

import com.studywithus.domain.entity.study.MemberStudy;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MemberStudyRepositoryImpl extends QuerydslRepositorySupport implements MemberStudyRepositoryCustom {

    public MemberStudyRepositoryImpl() {
        super(MemberStudy.class);
    }
}
