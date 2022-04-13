package com.studywithus.web.controller.study.studyboardcommentrecommend;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.studywithus.config.jwt.JwtProperties;
import com.studywithus.domain.entity.study.StudyBoard;
import com.studywithus.domain.service.study.studyboardcommentrecommend.StudyBoardCommentRecommendService;
import com.studywithus.web.controller.common.SuccessResult;
import com.studywithus.web.controller.study.studyboardcommentrecommend.dto.ResponseStudyBoardCommentRecommendDto;
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
public class StudyBoardCommentRecommendControllerImpl implements StudyBoardCommentRecommendController{
    private final StudyBoardCommentRecommendService studyBoardCommentRecommendService;

    @GetMapping("studies/{studyId}/studyBoards/{studyBoardId}/studyBoardComments/{studyBoardCommentId}/Recommend")
    public SuccessResult isRecommendStudyBoardComment(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId, @PathVariable Long studyBoardCommentId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();
        Long result = studyBoardCommentRecommendService.selectStudyBoardCommentRecommend(verifyId, studyBoardCommentId);

        if(result.equals(0L)){
            ResponseStudyBoardCommentRecommendDto isRecommendStudyBoardComment = new ResponseStudyBoardCommentRecommendDto(false);
            return new SuccessResult(isRecommendStudyBoardComment, "추천하지 않았습니다", "success");
        }
        ResponseStudyBoardCommentRecommendDto isRecommendStudyBoardComment = new ResponseStudyBoardCommentRecommendDto(true);
        return new SuccessResult(isRecommendStudyBoardComment, "이미 추천하였습니다.", "success");
    }


    @PostMapping("studies/{studyId}/studyBoards/{studyBoardId}/studyBoardComments/{studyBoardCommentId}/Recommend")
    public SuccessResult joinDropStudyBoardCommentRecommend(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId,  @PathVariable Long studyBoardCommentId) {
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        Long result = studyBoardCommentRecommendService.joinDropStudyBoardCommentRecommend(verifyId, studyBoardCommentId);
        if(result.equals(-1L)){
            ResponseStudyBoardCommentRecommendDto isRecommendStudyBoardComment = new ResponseStudyBoardCommentRecommendDto(true);
            return new SuccessResult(isRecommendStudyBoardComment, "추천 반영 완료", "success");
        }
        ResponseStudyBoardCommentRecommendDto isRecommendStudyBoardComment = new ResponseStudyBoardCommentRecommendDto(false);
        return new SuccessResult(isRecommendStudyBoardComment, "추천 취소 완료", "success");
    }
}
