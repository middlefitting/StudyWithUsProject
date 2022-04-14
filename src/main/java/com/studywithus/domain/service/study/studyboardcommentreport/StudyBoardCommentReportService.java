package com.studywithus.domain.service.study.studyboardcommentreport;

import com.studywithus.domain.service.study.studyboardcommentreport.dto.CreateStudyBoardCommentReportDto;
import com.studywithus.domain.service.study.studyboardreport.dto.CreateStudyBoardReportDto;

public interface StudyBoardCommentReportService {

    Long selectStudyBoardCommentReport(Long memberId, Long studyBoardCommentId);

    Long joinDropStudyBoardCommentReport(CreateStudyBoardCommentReportDto requestDto);
}
