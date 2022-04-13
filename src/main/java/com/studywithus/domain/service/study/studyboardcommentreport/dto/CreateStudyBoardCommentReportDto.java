package com.studywithus.domain.service.study.studyboardcommentreport.dto;

import com.studywithus.domain.entity.study.StudyBoardCommentReportCategory;
import com.studywithus.domain.entity.study.StudyBoardReportCategory;
import lombok.Data;

@Data
public class CreateStudyBoardCommentReportDto {
    private Long memberId;
    private Long studyBoardCommentId;
    private StudyBoardCommentReportCategory studyBoardCommentReportCategory;

    public CreateStudyBoardCommentReportDto(Long memberId, Long studyBoardCommentId, StudyBoardCommentReportCategory studyBoardCommentReportCategory) {
        this.memberId = memberId;
        this.studyBoardCommentId = studyBoardCommentId;
        this.studyBoardCommentReportCategory = studyBoardCommentReportCategory;
    }
}
