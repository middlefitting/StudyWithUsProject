package com.studywithus.domain.service.study.study.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CreateStudyDto {
    private String studyName;
    private String studyExplanation;
    private Long memberId;

    public CreateStudyDto(){
    }

    @Builder
    public CreateStudyDto(String studyName, String studyExplanation, Long memberId) {
        this.studyName = studyName;
        this.studyExplanation = studyExplanation;
        this.memberId = memberId;
    }
}
