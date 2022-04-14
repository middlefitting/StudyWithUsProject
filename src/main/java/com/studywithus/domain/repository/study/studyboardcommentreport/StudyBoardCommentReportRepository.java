package com.studywithus.domain.repository.study.studyboardcommentreport;

import com.studywithus.domain.entity.study.StudyBoardCommentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StudyBoardCommentReportRepository extends JpaRepository<StudyBoardCommentReport, Long>, StudyBoardCommentReportRepositoryCustom, QuerydslPredicateExecutor<StudyBoardCommentReport> {
}
