package com.studywithus.repository.study;

import com.studywithus.domain.study.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StudyRepository extends JpaRepository<Study, Long>, QuerydslPredicateExecutor<Study> {
}
