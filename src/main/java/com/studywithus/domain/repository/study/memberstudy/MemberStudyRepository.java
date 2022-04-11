package com.studywithus.domain.repository.study.memberstudy;

import com.studywithus.domain.entity.study.MemberStudy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberStudyRepository extends JpaRepository<MemberStudy, Long>, MemberStudyRepositoryCustom, QuerydslPredicateExecutor<MemberStudy> {
}
