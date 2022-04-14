package com.studywithus.web.controller.study.study.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class GetStudyResponseDto {

    private String studyName;
    private String studyExplanation;

    public GetStudyResponseDto(String studyName, String studyExplanation) {
        this.studyName = studyName;
        this.studyExplanation = studyExplanation;
    }
}
