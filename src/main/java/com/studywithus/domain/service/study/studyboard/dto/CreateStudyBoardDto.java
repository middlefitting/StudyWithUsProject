package com.studywithus.domain.service.study.studyboard.dto;

import com.studywithus.domain.entity.study.StudyBoardCategory;
import lombok.Data;

@Data
public class CreateStudyBoardDto {
    private Long memberId;
    private Long studyId;
    private String title;
    private String content;
    private StudyBoardCategory studyBoardCategory;

    public CreateStudyBoardDto(Long memberId, Long studyId, String title, String content, StudyBoardCategory studyBoardCategory) {
        this.memberId = memberId;
        this.studyId = studyId;
        this.title = title;
        this.content = content;
        this.studyBoardCategory = studyBoardCategory;
    }
}
