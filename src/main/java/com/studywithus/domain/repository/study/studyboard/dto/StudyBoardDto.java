package com.studywithus.domain.repository.study.studyboard.dto;


import com.querydsl.core.annotations.QueryProjection;
import com.studywithus.domain.entity.study.StudyBoardCategory;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudyBoardDto {
    private Long studyBoardId;
    private Long studyId;
    private Long studyBoardMemberId;

    private LocalDateTime regDate;
    private String nickname;
    private String title;
    private String content;
    private StudyBoardCategory studyBoardCategory;

    private Long StudyBoardCommentCount;
    private Long StudyBoardRecommendCount;
    private Long StudyBoardReportCount;
    private Long StudyBoardViewCount;

    @QueryProjection
    public StudyBoardDto(Long studyBoardId, Long studyId, Long studyBoardMemberId, LocalDateTime regDate, String nickname, String title, String content, StudyBoardCategory studyBoardCategory, Long studyBoardCommentCount, Long studyBoardRecommendCount, Long studyBoardReportCount, Long studyBoardViewCount) {
        this.studyBoardId = studyBoardId;
        this.studyId = studyId;
        this.studyBoardMemberId = studyBoardMemberId;
        this.regDate = regDate;
        this.nickname = nickname;
        this.title = title;
        this.content = content;
        this.studyBoardCategory = studyBoardCategory;
        StudyBoardCommentCount = studyBoardCommentCount;
        StudyBoardRecommendCount = studyBoardRecommendCount;
        StudyBoardReportCount = studyBoardReportCount;
        StudyBoardViewCount = studyBoardViewCount;
    }
}
