package com.studywithus.domain.repository.study.Study.dto;

import lombok.Data;

import com.querydsl.core.annotations.QueryProjection;

import java.time.LocalDateTime;

@Data
public class StudyDto {
    private Long studyId;
    private LocalDateTime regDate;
    private String studyName;
    private String studyExplanation;
    private String nickName;
    private Long memberId;
    private Long studyMemberCount;

    @QueryProjection
    public StudyDto(Long studyId, LocalDateTime regDate, String studyName, String studyExplanation, String nickName, Long studyMemberCount) {
        this.studyId = studyId;
        this.regDate = regDate;
        this.studyName = studyName;
        this.studyExplanation = studyExplanation;
        this.nickName = nickName;
        this.studyMemberCount = studyMemberCount;
    }
}
