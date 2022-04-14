package com.studywithus.domain.repository.study.studyboardfiledir;

import com.studywithus.domain.entity.study.StudyBoardFileDir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StudyBoardFileDirRepository extends JpaRepository<StudyBoardFileDir, Long>, StudyBoardFileDirRepositoryCustom, QuerydslPredicateExecutor<StudyBoardFileDir> {
}
