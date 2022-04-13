package com.studywithus.domain.service.study.studyboardcomment;

import com.studywithus.domain.repository.study.studyboardcomment.dto.StudyBoardCommentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudyBoardCommentService {

    Page<StudyBoardCommentDto> selectStudyBoardComments(Pageable pageable, Long studyBoardId);

}
