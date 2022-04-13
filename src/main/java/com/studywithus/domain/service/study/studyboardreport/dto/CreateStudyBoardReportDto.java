package com.studywithus.domain.service.study.studyboardreport.dto;

import com.studywithus.domain.entity.study.StudyBoardReportCategory;
import lombok.Data;

@Data
public class CreateStudyBoardReportDto {
    private Long memberId;
    private Long studyBoardId;
    private StudyBoardReportCategory studyBoardReportCategory;

    public CreateStudyBoardReportDto(Long memberId, Long studyBoardId, StudyBoardReportCategory studyBoardReportCategory) {
        this.memberId = memberId;
        this.studyBoardId = studyBoardId;
        this.studyBoardReportCategory = studyBoardReportCategory;
    }
}
