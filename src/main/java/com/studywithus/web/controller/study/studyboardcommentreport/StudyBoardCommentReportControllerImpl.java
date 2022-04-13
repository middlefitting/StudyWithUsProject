package com.studywithus.web.controller.study.studyboardcommentreport;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.studywithus.config.jwt.JwtProperties;
import com.studywithus.domain.entity.study.StudyBoardCommentReportCategory;
import com.studywithus.domain.entity.study.StudyBoardReportCategory;
import com.studywithus.domain.service.study.studyboardcommentreport.StudyBoardCommentReportService;
import com.studywithus.domain.service.study.studyboardcommentreport.dto.CreateStudyBoardCommentReportDto;
import com.studywithus.domain.service.study.studyboardreport.dto.CreateStudyBoardReportDto;
import com.studywithus.web.controller.common.SuccessResult;
import com.studywithus.web.controller.study.studyboardcommentreport.dto.ResponseStudyBoardCommentReportDto;
import com.studywithus.web.controller.study.studyboardreport.form.ResponseStudyBoardReportDto;
import com.studywithus.web.controller.study.studyboardcommentreport.form.CreateStudyBoardCommentReportForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudyBoardCommentReportControllerImpl implements StudyBoardCommentReportController{

    private final StudyBoardCommentReportService studyBoardCommentReportService;

    @GetMapping("studies/{studyId}/studyBoards/{studyBoardId}/studyBoardComments/{studyBoardCommentId}/Report")
    public SuccessResult isRecommendStudyBoardComment(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId, @PathVariable Long studyBoardCommentId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();
        Long result = studyBoardCommentReportService.selectStudyBoardCommentReport(verifyId, studyBoardCommentId);

        if(result.equals(0L)){
            ResponseStudyBoardCommentReportDto isReportStudyBoardComment = new ResponseStudyBoardCommentReportDto(false);
            return new SuccessResult(isReportStudyBoardComment, "신고하지 않았습니다", "success");
        }
        ResponseStudyBoardCommentReportDto isReportStudyBoardComment = new ResponseStudyBoardCommentReportDto(true);
        return new SuccessResult(isReportStudyBoardComment, "이미 신고하였습니다.", "success");
    }


    @PostMapping("studies/{studyId}/studyBoards/{studyBoardId}/studyBoardComments/{studyBoardCommentId}/Report")
    public SuccessResult joinDropStudyBoardCommentRecommend(HttpServletRequest request, @PathVariable Long studyId, @RequestBody @Validated CreateStudyBoardCommentReportForm requestForm,
                                                     BindingResult bindingResult, @PathVariable Long studyBoardId, @PathVariable Long studyBoardCommentId) {
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            throw new IllegalArgumentException("입력 값이 잘못되었습니다!");
        }

        if(!requestForm.getStudyBoardCommentReportCategory().equals("sensational") && !requestForm.getStudyBoardCommentReportCategory().equals("commercial") && !requestForm.getStudyBoardCommentReportCategory().equals("abuse") && !requestForm.getStudyBoardCommentReportCategory().equals("ex")){
            throw new IllegalArgumentException("카테고리 값이 잘못되었습니다!");
        }

        CreateStudyBoardCommentReportDto requestDto = new CreateStudyBoardCommentReportDto(verifyId, studyBoardCommentId, StudyBoardCommentReportCategory.valueOf(requestForm.getStudyBoardCommentReportCategory()));
        Long result = studyBoardCommentReportService.joinDropStudyBoardCommentReport(requestDto);

        if(result.equals(-1L)){
            ResponseStudyBoardCommentReportDto isReportStudyBoardComment = new ResponseStudyBoardCommentReportDto(true);
            return new SuccessResult(isReportStudyBoardComment, "신고를 완료하였습니다", "success");
        }
        ResponseStudyBoardCommentReportDto isReportStudyBoardComment = new ResponseStudyBoardCommentReportDto(true);
        return new SuccessResult(isReportStudyBoardComment, "이미 신고하였습니다!", "success");
    }
}
