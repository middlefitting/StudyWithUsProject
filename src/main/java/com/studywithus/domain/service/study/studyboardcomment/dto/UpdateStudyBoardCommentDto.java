package com.studywithus.domain.service.study.studyboardcomment.dto;

import lombok.Data;

@Data
public class UpdateStudyBoardCommentDto {
    private Long memberId;
    private Long studyBoardId;
    private String content;

    public UpdateStudyBoardCommentDto(Long memberId, Long studyBoardId, String content) {
        this.memberId = memberId;
        this.studyBoardId = studyBoardId;
        this.content = content;
    }
}
