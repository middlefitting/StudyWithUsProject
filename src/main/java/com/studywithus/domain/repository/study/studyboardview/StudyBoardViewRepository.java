package com.studywithus.domain.repository.study.studyboardview;

import com.studywithus.domain.entity.study.StudyBoardView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StudyBoardViewRepository extends JpaRepository<StudyBoardView, Long>, StudyBoardViewRepositoryCustom, QuerydslPredicateExecutor<StudyBoardView> {
}
