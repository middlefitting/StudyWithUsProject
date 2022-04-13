package com.studywithus.domain.service.study.studyboardcomment;

import com.studywithus.domain.entity.study.StudyBoardComment;
import com.studywithus.domain.repository.study.studyboardcomment.dto.StudyBoardCommentDto;
import com.studywithus.domain.service.study.studyboardcomment.dto.CreateStudyBoardCommentDto;
import com.studywithus.domain.service.study.studyboardcomment.dto.UpdateStudyBoardCommentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudyBoardCommentService {

    Page<StudyBoardCommentDto> selectStudyBoardComments(Pageable pageable, Long studyBoardId);

    Long createStudyBoardComments(CreateStudyBoardCommentDto requestDto);

    Optional<StudyBoardComment> selectStudyBoardCommentSingle(Long memberId, Long studyBoardCommentId);

    Optional<StudyBoardComment> updateStudyBoardComment(UpdateStudyBoardCommentDto requestDto);

    Long deleteStudyBoardComment(Long memberId, Long studyBoardCommentId);

}
