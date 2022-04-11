package com.studywithus.domain.repository.study.studyboardrecommend;

import com.studywithus.domain.entity.study.StudyBoardRecommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StudyBoardRecommendRepository extends JpaRepository<StudyBoardRecommend, Long>, StudyBoardRecommendRepositoryCustom, QuerydslPredicateExecutor<StudyBoardRecommend> {
}
