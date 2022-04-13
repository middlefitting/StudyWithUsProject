package com.studywithus.web.controller.study.studyboardcomment;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.studywithus.config.jwt.JwtProperties;
import com.studywithus.domain.entity.study.StudyBoardComment;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardPageSearchCondition;
import com.studywithus.domain.repository.study.studyboardcomment.dto.StudyBoardCommentDto;
import com.studywithus.domain.service.study.studyboardcomment.StudyBoardCommentService;
import com.studywithus.web.controller.common.SuccessResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudyBoardCommentControllerImpl implements StudyBoardCommentController{

    private final StudyBoardCommentService studyBoardCommentService;

    @GetMapping("/studies/{studyId}/studyBoard/{studyBoardId}/studyBoardComments")
    public SuccessResult selectStudyBoards(HttpServletRequest request, @PageableDefault(size = 10, page = 0, sort = "regDate", direction = Sort.Direction.ASC) Pageable pageable,
                                           @PathVariable Long studyId, @PathVariable  Long studyBoardId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);

        Page<StudyBoardCommentDto> pageResults = studyBoardCommentService.selectStudyBoardComments(pageable, studyBoardId);
        return new SuccessResult(pageResults, "댓글 정보 반환 완료", "success");
    }





}
