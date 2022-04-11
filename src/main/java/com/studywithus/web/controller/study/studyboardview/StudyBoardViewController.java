package com.studywithus.web.controller.study.studyboardview;

import com.studywithus.domain.entity.study.StudyBoardView;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface StudyBoardViewController {
    List<StudyBoardView> getViews(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId, @PathVariable String studyBoardCategory);
}
