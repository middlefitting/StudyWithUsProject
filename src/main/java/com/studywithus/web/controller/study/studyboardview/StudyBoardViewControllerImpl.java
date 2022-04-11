package com.studywithus.web.controller.study.studyboardview;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.studywithus.config.jwt.JwtProperties;
import com.studywithus.domain.entity.study.StudyBoardView;
import com.studywithus.domain.repository.study.studyboardview.StudyBoardViewRepository;
import com.studywithus.domain.service.study.studyboardview.StudyBoardViewService;
import com.studywithus.web.controller.common.SuccessResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudyBoardViewControllerImpl implements StudyBoardViewController {
    private final StudyBoardViewService studyBoardViewService;
    private final StudyBoardViewRepository studyBoardViewRepository;

    @GetMapping("studies/{studyId}/studyBoards/{studyBoardId}/{studyBoardCategory}/Views") //jwt 토큰 기반으로 찾음
    public List<StudyBoardView> getViews(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId, @PathVariable String studyBoardCategory) {
        System.out.println(studyBoardId);
//        List<StudyBoardView> views = studyBoardViewRepository.findStudyBoardViews(studyBoardId);
//        List<StudyBoardView> studyBoardViews = studyBoardViewRepository.findStudyBoardViews(studyBoardId);
        List<StudyBoardView> studyBoardViews = studyBoardViewService.selectStudyBoardViews(studyBoardId);
        System.out.println(studyBoardViews);

        return studyBoardViews;
    }


    @PostMapping("studies/{studyId}/studyBoards/{studyBoardId}/{studyBoardCategory}/Views") //jwt 토큰 기반으로 찾음
    public SuccessResult postViews(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId, @PathVariable String studyBoardCategory) {
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long memberId = verify.getClaim("id").asLong();


        return null;
    }
}

