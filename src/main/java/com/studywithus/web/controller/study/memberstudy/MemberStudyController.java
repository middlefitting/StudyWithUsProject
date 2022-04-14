package com.studywithus.web.controller.study.memberstudy;

import com.studywithus.web.controller.common.SuccessResult;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

public interface MemberStudyController {

    SuccessResult isStudyMember(HttpServletRequest request, @PathVariable Long studyId);

    SuccessResult joinMemberStudy(HttpServletRequest request, @PathVariable Long studyId);

}
