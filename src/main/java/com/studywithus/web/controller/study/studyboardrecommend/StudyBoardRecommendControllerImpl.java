package com.studywithus.web.controller.study.studyboardrecommend;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.studywithus.config.jwt.JwtProperties;
import com.studywithus.domain.repository.study.studyboardrecommend.StudyBoardRecommendRepository;
import com.studywithus.domain.service.study.studyboardrecommend.StudyBoardRecommendService;
import com.studywithus.web.controller.common.SuccessResult;
import com.studywithus.web.controller.study.memberstudy.dto.ResponseIsStudyMemberDto;
import com.studywithus.web.controller.study.studyboardrecommend.dto.ResponseStudyBoardRecommendDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudyBoardRecommendControllerImpl implements StudyBoardRecommendController{

    private final StudyBoardRecommendService studyBoardRecommendService;

    @GetMapping("studies/{studyId}/studyBoards/{studyBoardId}/Recommend")
    public SuccessResult isRecommendStudyBoard(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();
        Long result = studyBoardRecommendService.selectStudyBoardRecommend(verifyId, studyBoardId);

        if(result.equals(0L)){
            ResponseStudyBoardRecommendDto isRecommendStudyBoard = new ResponseStudyBoardRecommendDto(false);
            return new SuccessResult(isRecommendStudyBoard, "추천하지 않았습니다", "success");
        }
        ResponseStudyBoardRecommendDto isRecommendStudyBoard = new ResponseStudyBoardRecommendDto(true);
        return new SuccessResult(isRecommendStudyBoard, "이미 추천하였습니다.", "success");
    }


    @PostMapping("studies/{studyId}/studyBoards/{studyBoardId}/Recommend")
    public SuccessResult joinDropStudyBoardRecommend(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId) {
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        Long result = studyBoardRecommendService.joinDropStudyBoardRecommend(verifyId, studyBoardId);
        if(result.equals(-1L)){
            ResponseStudyBoardRecommendDto isRecommendStudyBoard = new ResponseStudyBoardRecommendDto(true);
            return new SuccessResult(isRecommendStudyBoard, "추천 반영 완료", "success");
        }
        ResponseStudyBoardRecommendDto isRecommendStudyBoard = new ResponseStudyBoardRecommendDto(false);
        return new SuccessResult(isRecommendStudyBoard, "추천 취소 완료", "success");
    }
}
