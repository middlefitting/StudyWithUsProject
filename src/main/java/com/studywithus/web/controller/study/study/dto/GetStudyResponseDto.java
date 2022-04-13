package com.studywithus.web.controller.study.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Builder
public class GetStudyResponseDto {
    private Long studyId;
    private Long studyMasterId;
    private String studyName;
    private String studyExplanation;
    private Long studyMemberCount;
    private String studyMasterNickname;
    private LocalDateTime regDate;


    public GetStudyResponseDto(Long studyId, Long studyMasterId, String studyName, String studyExplanation, Long studyMemberCount, String studyMasterNickname, LocalDateTime regDate) {
        this.studyId = studyId;
        this.studyMasterId = studyMasterId;
        this.studyName = studyName;
        this.studyExplanation = studyExplanation;
        this.studyMemberCount = studyMemberCount;
        this.studyMasterNickname = studyMasterNickname;
        this.regDate = regDate;
    }
}
