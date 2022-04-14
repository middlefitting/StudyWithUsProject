package com.studywithus.web.controller.study.studyboardcommentreport.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateStudyBoardCommentReportForm {
    @NotBlank
    private String studyBoardCommentReportCategory;
}
