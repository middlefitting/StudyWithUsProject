package com.studywithus.domain.service.study.studyboardreport;

import com.studywithus.domain.service.study.studyboardreport.dto.CreateStudyBoardReportDto;

public interface StudyBoardReportService {
    Long selectStudyBoardReport(Long memberId, Long studyBoardId);

    Long joinDropStudyBoardReport(CreateStudyBoardReportDto requestDto);
}
