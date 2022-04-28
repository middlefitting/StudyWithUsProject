package com.studywithus.domain.repository.study.studyboard.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.studywithus.domain.entity.study.StudyBoardCategory;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudyBoardSingleDto {
    private Long studyBoardId;
    private String content;
    private String title;
    private StudyBoardCategory studyBoardCategory;
    private String nickname;
    private LocalDateTime regDate;
    private Long studyBoardCommentCount;
    private Long studyBoardRecommendCount;
    private Long studyBoardReportCount;
    private Long studyBoardViewCount;

    @QueryProjection
    public StudyBoardSingleDto(Long studyBoardId, String content, String title, StudyBoardCategory studyBoardCategory, String nickname, LocalDateTime regDate, Long studyBoardCommentCount, Long studyBoardRecommendCount, Long studyBoardReportCount, Long studyBoardViewCount) {
        this.studyBoardId = studyBoardId;
        this.content = content;
        this.title = title;
        this.studyBoardCategory = studyBoardCategory;
        this.nickname = nickname;
        this.regDate = regDate;
        this.studyBoardCommentCount = studyBoardCommentCount;
        this.studyBoardRecommendCount = studyBoardRecommendCount;
        this.studyBoardReportCount = studyBoardReportCount;
        this.studyBoardViewCount = studyBoardViewCount;
    }
}
