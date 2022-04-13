package com.studywithus.domain.repository.study.studyboardcommentrecommend;

import com.studywithus.domain.entity.study.StudyBoardCommentRecommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface StudyBoardCommentRecommendRepository extends JpaRepository<StudyBoardCommentRecommend, Long>, StudyBoardCommentRecommendRepositoryCustom, QuerydslPredicateExecutor<StudyBoardCommentRecommend> {
    public Optional<StudyBoardCommentRecommend> findByMemberIdAndStudyBoardCommentId(Long memberId, Long studyBoardCommentId);
}
