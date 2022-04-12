package com.studywithus.domain.repository.study.study;

import com.querydsl.core.types.OrderSpecifier;
import com.studywithus.domain.repository.study.study.dto.StudyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudyRepositoryCustom {
    private OrderSpecifier<?> studySort(Pageable pageable) {
        return null;
    }

    Page<StudyDto> searchStudyPage(Pageable pageable);

    Optional<Long> searchStudyByMember(Long memberId);
}
