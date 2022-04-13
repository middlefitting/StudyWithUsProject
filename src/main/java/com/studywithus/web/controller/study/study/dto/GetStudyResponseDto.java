package com.studywithus.web.controller.study.study.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class GetStudyResponseDto {

    private String studyName;
    private String studyExplanation;
    private Long studyMemberCount;

    public GetStudyResponseDto(String studyName, String studyExplanation, Long studyMemberCount) {
        this.studyName = studyName;
        this.studyExplanation = studyExplanation;
        this.studyMemberCount = studyMemberCount;
    }
}
