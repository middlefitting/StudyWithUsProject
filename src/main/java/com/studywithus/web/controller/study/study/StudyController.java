package com.studywithus.web.controller.study.study;


import com.studywithus.domain.repository.study.Study.dto.StudyPageSearchCondition;
import com.studywithus.web.controller.common.SuccessResult;
import com.studywithus.web.controller.study.study.form.CreateStudyForm;
import com.studywithus.web.controller.study.study.form.UpdateStudyForm;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

public interface StudyController {
    SuccessResult selectStudies(HttpServletRequest request, @PageableDefault(size = 10, page = 0, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable, StudyPageSearchCondition condition);

    SuccessResult createStudy(HttpServletRequest request, @RequestBody @Validated CreateStudyForm requestForm, BindingResult bindingResult);

    SuccessResult getStudy(HttpServletRequest request, @PathVariable Long studyId);

    SuccessResult updateStudy(HttpServletRequest request, @PathVariable Long studyId, @RequestBody @Validated UpdateStudyForm requestForm, BindingResult bindingResult);

    SuccessResult deleteStudy(HttpServletRequest request, @PathVariable Long studyId);
}
