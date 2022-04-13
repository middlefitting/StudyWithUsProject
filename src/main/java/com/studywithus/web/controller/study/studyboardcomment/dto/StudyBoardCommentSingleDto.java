package com.studywithus.web.controller.study.studyboardcomment.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StudyBoardCommentSingleDto {
    private Long studyBoardCommentId;
    private Long studyBoardId;
    private Long memberId;

    private String nickname;
    private String content;
    private Long studyBoardCommentRecommendCount;
    private Long studyBoardCommentReportCount;
    private LocalDateTime regDate;

    public StudyBoardCommentSingleDto(Long studyBoardCommentId, Long studyBoardId, Long memberId, String nickname, String content, Long studyBoardCommentRecommendCount, Long studyBoardCommentReportCount, LocalDateTime regDate) {
        this.studyBoardCommentId = studyBoardCommentId;
        this.studyBoardId = studyBoardId;
        this.memberId = memberId;
        this.nickname = nickname;
        this.content = content;
        this.studyBoardCommentRecommendCount = studyBoardCommentRecommendCount;
        this.studyBoardCommentReportCount = studyBoardCommentReportCount;
        this.regDate = regDate;
    }
}
