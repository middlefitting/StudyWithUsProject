package com.studywithus.domain.repository.study.studyboardcomment;

import com.studywithus.domain.entity.study.StudyBoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StudyBoardCommentRepository extends JpaRepository<StudyBoardComment, Long>, StudyBoardCommentRepositoryCustom, QuerydslPredicateExecutor<StudyBoardComment> {
}
