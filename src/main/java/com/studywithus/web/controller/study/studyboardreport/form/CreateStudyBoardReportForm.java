package com.studywithus.web.controller.study.studyboardreport.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateStudyBoardReportForm {
    @NotBlank
    private String studyBoardReportCategory;
}

