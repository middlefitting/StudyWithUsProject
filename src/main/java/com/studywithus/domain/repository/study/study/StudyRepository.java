package com.studywithus.domain.repository.study.Study;

import com.studywithus.domain.entity.study.Study;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long>, StudyRepositoryCustom, QuerydslPredicateExecutor<Study> {

}
