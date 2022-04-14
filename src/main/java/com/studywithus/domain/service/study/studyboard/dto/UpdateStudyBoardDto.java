package com.studywithus.domain.service.study.studyboard.dto;

import com.studywithus.domain.entity.study.StudyBoardCategory;
import lombok.Data;

@Data
public class UpdateStudyBoardDto {
    private Long studyBoardId;
    private Long memberId;
    private String title;
    private String content;
    private StudyBoardCategory studyBoardCategory;

    public UpdateStudyBoardDto(Long studyBoardId, Long memberId, String title, String content, StudyBoardCategory studyBoardCategory) {
        this.studyBoardId = studyBoardId;
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.studyBoardCategory = studyBoardCategory;
    }
}
