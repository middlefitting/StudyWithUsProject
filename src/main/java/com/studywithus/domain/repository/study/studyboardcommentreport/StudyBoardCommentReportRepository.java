package com.studywithus.domain.repository.study.studyboardcommentreport;

import com.studywithus.domain.entity.study.StudyBoardCommentReport;
import com.studywithus.domain.entity.study.StudyBoardReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface StudyBoardCommentReportRepository extends JpaRepository<StudyBoardCommentReport, Long>, StudyBoardCommentReportRepositoryCustom, QuerydslPredicateExecutor<StudyBoardCommentReport> {
    public Optional<StudyBoardCommentReport> findByMemberIdAndStudyBoardCommentId(Long memberId, Long studyBoardCommentId);
}
