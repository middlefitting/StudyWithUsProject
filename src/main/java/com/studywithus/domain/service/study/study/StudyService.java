package com.studywithus.domain.service.study.study;

import com.studywithus.domain.repository.study.Study.dto.StudyDto;
import com.studywithus.domain.service.study.study.dto.CreateStudyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudyService {
    Page<StudyDto> selectStudyPage(Pageable pageable);

    Long createStudy(CreateStudyDto requestDto);

    Long joinDropStudy(Long memberId, Long StudyId);
}
