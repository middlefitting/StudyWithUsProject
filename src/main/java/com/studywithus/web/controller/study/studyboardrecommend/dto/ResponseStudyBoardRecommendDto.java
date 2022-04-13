package com.studywithus.web.controller.study.studyboardrecommend.dto;

import lombok.Data;

@Data
public class ResponseStudyBoardRecommendDto {
    private boolean isRecommendStudyBoard;

    public ResponseStudyBoardRecommendDto(boolean isRecommendStudyBoard) {
        this.isRecommendStudyBoard = isRecommendStudyBoard;
    }
}
