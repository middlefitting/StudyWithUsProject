package com.studywithus.domain.repository.study.studyboardcomment;

import com.querydsl.core.types.OrderSpecifier;
import com.studywithus.domain.repository.study.studyboardcomment.dto.StudyBoardCommentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudyBoardCommentRepositoryCustom {

    private OrderSpecifier<?> studyBoardCommentSort(Pageable pageable){
        return null;
    }

    Page<StudyBoardCommentDto> searchStudyBoardComment(Pageable pageable, Long studyBoardId);

    Optional<String> searchStudyBoardCommentSingleContent(Long memberId, Long studyBoardCommentId);
}
