package com.studywithus.web.controller.study.study;

import com.studywithus.domain.repository.study.study.dto.StudyDto;
import com.studywithus.web.controller.common.SuccessResult;
import com.studywithus.web.controller.study.study.form.CreateStudyForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

public interface StudyController {
    SuccessResult selectStudies(HttpServletRequest request, @PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable);

    SuccessResult joinMember(HttpServletRequest request, @RequestBody @Validated CreateStudyForm requestForm, BindingResult bindingResult);

    SuccessResult joinMember(HttpServletRequest request, @PathVariable Long studyId);
}
