package com.studywithus.domain.service.study.studyboardrecommend;

public interface StudyBoardRecommendService {

    Long selectStudyBoardRecommend(Long memberId, Long studyBoardId);

    Long joinDropStudyBoardRecommend(Long memberId, Long studyBoardId);
}
