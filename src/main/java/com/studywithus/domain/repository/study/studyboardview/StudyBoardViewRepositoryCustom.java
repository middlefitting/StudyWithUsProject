package com.studywithus.domain.repository.study.studyboardview;

import com.studywithus.domain.entity.study.StudyBoardView;

import java.util.List;
import java.util.Optional;

public interface StudyBoardViewRepositoryCustom {
    List<StudyBoardView> findStudyBoardViews(Long studyBoardId);
    List<Long> findStudyBoardViews2();
}
