package com.studywithus.domain.repository.study.studyboard;

import com.querydsl.core.types.OrderSpecifier;
import com.studywithus.domain.entity.study.StudyBoard;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardDto;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardPageSearchCondition;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardSingleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudyBoardRepositoryCustom {
    private OrderSpecifier<?> studyBoardSort(Pageable pageable){return null;}

    Page<StudyBoardDto> searchStudyBoardPage(Pageable pageable, StudyBoardPageSearchCondition condition);

    Optional<StudyBoardSingleDto> searchStudyBoardSingle(Long id);

    Optional<StudyBoard> searchStudyBoardByBoardAndMemberId(Long memberId, Long boardId);
}
