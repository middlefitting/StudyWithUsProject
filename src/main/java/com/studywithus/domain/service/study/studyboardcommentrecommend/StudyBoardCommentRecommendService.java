package com.studywithus.domain.service.study.studyboardcommentrecommend;

public interface StudyBoardCommentRecommendService {

    Long selectStudyBoardCommentRecommend(Long memberId, Long studyBoardCommentId);

    Long joinDropStudyBoardCommentRecommend(Long memberId, Long studyBoardCommentId);
}
