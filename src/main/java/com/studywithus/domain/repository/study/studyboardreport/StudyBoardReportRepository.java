package com.studywithus.domain.repository.study.studyboardreport;

import com.studywithus.domain.entity.study.StudyBoardReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface StudyBoardReportRepository extends JpaRepository<StudyBoardReport, Long>, StudyBoardReportRepositoryCustom, QuerydslPredicateExecutor<StudyBoardReport> {
    public Optional<StudyBoardReport> findByMemberIdAndStudyBoardId(Long memberId, Long studyBoardId);
}
