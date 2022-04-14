package com.studywithus.domain.service.study.studyboardcomment.dto;

import lombok.Data;

@Data
public class CreateStudyBoardCommentDto {
    private Long memberId;
    private Long studyId;
    private Long studyBoardId;
    private String content;

    public CreateStudyBoardCommentDto(Long memberId, Long studyId, Long studyBoardId, String content) {
        this.memberId = memberId;
        this.studyId = studyId;
        this.studyBoardId = studyBoardId;
        this.content = content;
    }
}
