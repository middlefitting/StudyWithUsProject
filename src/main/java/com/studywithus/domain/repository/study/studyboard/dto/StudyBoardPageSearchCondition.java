package com.studywithus.domain.repository.study.studyboard.dto;

import lombok.Data;

@Data
public class StudyBoardPageSearchCondition {
    private String studyBoardWriterNickname;
    private String studyBoardTitle;
    private String studyBoardContent;
    private String studyBoardCategory;
    private Long studyId;
}
