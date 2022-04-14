package com.studywithus.web.controller.study.studyboardcommentreport.dto;

import lombok.Data;

@Data
public class ResponseStudyBoardCommentReportDto {
    private boolean isReportStudyBoardComment;

    public ResponseStudyBoardCommentReportDto(boolean isReportStudyBoardComment) {
        this.isReportStudyBoardComment = isReportStudyBoardComment;
    }
}
