package com.studywithus.domain.service.study.studyboardview;

import com.studywithus.domain.entity.study.StudyBoardView;

import java.util.List;

public interface StudyBoardViewService {
    void appendStudyBoardViews(Long memberId, Long studyBoardId);
}
