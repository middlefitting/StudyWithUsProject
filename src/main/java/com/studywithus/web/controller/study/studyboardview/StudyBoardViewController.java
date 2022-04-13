package com.studywithus.web.controller.study.studyboardview;

import com.studywithus.web.controller.common.SuccessResult;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;

public interface StudyBoardViewController {
    SuccessResult getViews(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId);
}
