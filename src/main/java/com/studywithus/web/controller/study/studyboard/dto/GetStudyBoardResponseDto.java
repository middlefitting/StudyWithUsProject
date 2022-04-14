package com.studywithus.web.controller.study.studyboard.dto;

import java.time.LocalDateTime;

public class GetStudyBoardResponseDto {
    private Long studyBoardId;
    private String content;
    private String title;
    private String nickname;
    private LocalDateTime regDate;
    private Long studyBoardCommentCount;
    private Long studyBoardRecommendCount;
    private Long studyBoardReportCount;
    private Long studyBoardViewCount;


}
