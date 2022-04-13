package com.studywithus.domain.service.study.study;

import com.studywithus.domain.entity.study.Study;
import com.studywithus.domain.repository.study.Study.dto.StudyDto;
import com.studywithus.domain.repository.study.Study.dto.StudyPageSearchCondition;
import com.studywithus.domain.service.study.study.dto.CreateStudyDto;
import com.studywithus.domain.service.study.study.dto.UpdateStudyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudyService {
    Page<StudyDto> selectStudyPage(Pageable pageable, StudyPageSearchCondition condition);

    Long createStudy(CreateStudyDto requestDto);

    Optional<Study> getStudy(Long studyId, Long memberId);

    Long updateStudy(UpdateStudyDto requestDto);

    void deleteStudy(Long studyId, Long memberId);
}
