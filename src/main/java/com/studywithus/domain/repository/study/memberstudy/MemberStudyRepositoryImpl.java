package com.studywithus.domain.repository.study.memberstudy;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studywithus.domain.entity.study.MemberStudy;
import com.studywithus.domain.entity.study.QMemberStudy;
import com.studywithus.domain.entity.study.QStudy;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import java.util.Optional;

import static com.studywithus.domain.entity.study.QMemberStudy.*;
import static com.studywithus.domain.entity.study.QStudy.*;

public class MemberStudyRepositoryImpl implements MemberStudyRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MemberStudyRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    public Optional<Long> findByMemberIdAndStudyId(Long memberId, Long studyId){
        return Optional.ofNullable(queryFactory
                .select(memberStudy.id)
                .from(memberStudy)
                .where(memberStudy.member.id.eq(memberId)
                        .and(memberStudy.study.id.eq(studyId)))
                .fetchOne());
    }

    public Optional<Long> countMemberStudy(Long studyId){
        return Optional.ofNullable(queryFactory
                .select(memberStudy.count())
                .from(memberStudy)
                .join(memberStudy.study, study)
                .where(memberStudy.study.id.eq(studyId), study.id.eq(memberStudy.study.id))
                .fetchOne());
    }

}
