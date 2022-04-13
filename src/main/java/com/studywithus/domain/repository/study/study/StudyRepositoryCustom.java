package com.studywithus.domain.repository.study.study;

import com.querydsl.core.types.OrderSpecifier;

import com.studywithus.domain.repository.study.Study.dto.StudyDto;
import com.studywithus.domain.repository.study.Study.dto.StudyPageSearchCondition;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardSingleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudyRepositoryCustom {
    private OrderSpecifier<?> studySort(Pageable pageable) {
        return null;
    }

    Page<StudyDto> searchStudyPage(Pageable pageable, StudyPageSearchCondition condition);

    Optional<Long> searchStudyByMember(Long memberId);
}
