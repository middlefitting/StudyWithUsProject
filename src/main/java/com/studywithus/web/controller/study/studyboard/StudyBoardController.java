package com.studywithus.web.controller.study.studyboard;

import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardPageSearchCondition;
import com.studywithus.web.controller.common.SuccessResult;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

public interface StudyBoardController {
    SuccessResult selectStudyBoards(HttpServletRequest request, @PageableDefault(size = 10, page = 0, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable,
                                    StudyBoardPageSearchCondition condition, @PathVariable Long studyId, @PathVariable  String studyBoardCategory);
}
