package com.studywithus.domain.repository.study.studyboardreport;

import com.studywithus.domain.entity.study.StudyBoardReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StudyBoardReportRepository extends JpaRepository<StudyBoardReport, Long>, StudyBoardReportRepositoryCustom, QuerydslPredicateExecutor<StudyBoardReport> {
}
