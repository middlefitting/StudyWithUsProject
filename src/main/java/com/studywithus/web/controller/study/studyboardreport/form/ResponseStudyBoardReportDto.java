package com.studywithus.web.controller.study.studyboardreport.form;

import lombok.Data;

@Data
public class ResponseStudyBoardReportDto {
    private boolean isReportStudyBoard;

    public ResponseStudyBoardReportDto(boolean isReportStudyBoard) {
        this.isReportStudyBoard = isReportStudyBoard;
    }
}
