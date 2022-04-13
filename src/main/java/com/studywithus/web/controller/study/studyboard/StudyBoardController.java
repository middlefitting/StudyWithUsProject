package com.studywithus.web.controller.study.studyboard;

import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardPageSearchCondition;
import com.studywithus.web.controller.common.SuccessResult;
import com.studywithus.web.controller.study.studyboard.form.CreateStudyBoardForm;
import com.studywithus.web.controller.study.studyboard.form.UpdateStudyBoardForm;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

public interface StudyBoardController {
    SuccessResult selectStudyBoards(HttpServletRequest request, @PageableDefault(size = 10, page = 0, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable,
                                    StudyBoardPageSearchCondition condition, @PathVariable Long studyId, @PathVariable  String studyBoardCategory);

    SuccessResult createStudyBoard(HttpServletRequest request, @RequestBody @Validated CreateStudyBoardForm requestForm, BindingResult bindingResult, @PathVariable Long studyId);

    SuccessResult getStudyBoardSingle(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId);

    SuccessResult updateStudyBoard(HttpServletRequest request, @PathVariable Long studyId, @RequestBody @Validated UpdateStudyBoardForm requestForm, BindingResult bindingResult, @PathVariable Long studyBoardId);

    SuccessResult deleteStudy(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId);
}
