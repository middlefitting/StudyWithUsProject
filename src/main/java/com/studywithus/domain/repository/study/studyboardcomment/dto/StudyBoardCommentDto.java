package com.studywithus.domain.repository.study.studyboardcomment.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StudyBoardCommentDto {
    private Long studyBoardCommentId;
    private Long studyBoardId;
    private Long memberId;

    private String nickname;
    private String content;
    private Long studyBoardCommentRecommendCount;
    private Long studyBoardCommentReportCount;
    private LocalDateTime regDate;


    @QueryProjection
    public StudyBoardCommentDto(Long studyBoardCommentId, Long studyBoardId, Long memberId, String nickname, String content, Long studyBoardCommentRecommendCount, Long studyBoardCommentReportCount, LocalDateTime regDate) {
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
