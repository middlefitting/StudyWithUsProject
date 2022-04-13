package com.studywithus.domain.service.study.studyboard;

import com.studywithus.domain.entity.study.StudyBoard;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardDto;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardPageSearchCondition;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardSingleDto;
import com.studywithus.domain.service.study.studyboard.dto.CreateStudyBoardDto;
import com.studywithus.domain.service.study.studyboard.dto.UpdateStudyBoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudyBoardService {
    Page<StudyBoardDto> selectStudyBoardPage(Pageable pageable, StudyBoardPageSearchCondition condition);

    Long createStudyBoard(CreateStudyBoardDto requestDto);

    Optional<StudyBoardSingleDto> selectStudyBoard(Long studyBoardId);

    Long updateStudyBoard(UpdateStudyBoardDto requestDto);

    Long deleteStudyBoard(Long MemberId, Long StudyBoardId);
}
