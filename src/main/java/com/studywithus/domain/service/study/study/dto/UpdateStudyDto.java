package com.studywithus.domain.service.study.study.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UpdateStudyDto {
    private Long studyId;
    private String studyName;
    private String studyExplanation;
    private Long memberId;

    public UpdateStudyDto(){
    }

    @Builder
    public UpdateStudyDto(Long studyId, String studyName, String studyExplanation, Long memberId) {
        this.studyId = studyId;
        this.studyName = studyName;
        this.studyExplanation = studyExplanation;
        this.memberId = memberId;
    }
}
