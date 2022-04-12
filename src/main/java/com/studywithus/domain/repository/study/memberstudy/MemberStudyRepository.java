package com.studywithus.domain.repository.study.memberstudy;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.study.MemberStudy;

import com.studywithus.domain.entity.study.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberStudyRepository extends JpaRepository<MemberStudy, Long>, MemberStudyRepositoryCustom, QuerydslPredicateExecutor<MemberStudy> {

    public Optional<MemberStudy> findByMemberAndStudy(Member member, Study study);

}
