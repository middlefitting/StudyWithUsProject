package com.studywithus.web.controller.study.studyboardcommentrecommend.dto;

import lombok.Data;

@Data
public class ResponseStudyBoardCommentRecommendDto {
    private boolean isRecommendStudyBoardComment;

    public ResponseStudyBoardCommentRecommendDto(boolean isRecommendStudyBoardComment) {
        this.isRecommendStudyBoardComment = isRecommendStudyBoardComment;
    }
}
