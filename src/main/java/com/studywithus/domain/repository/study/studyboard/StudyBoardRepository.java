package com.studywithus.domain.repository.study.studyboard;

import com.studywithus.domain.entity.study.StudyBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StudyBoardRepository extends JpaRepository<StudyBoard, Long>, StudyBoardRepositoryCustom, QuerydslPredicateExecutor<StudyBoard> {
    //data_jpa
}
