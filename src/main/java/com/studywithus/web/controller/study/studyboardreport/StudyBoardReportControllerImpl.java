package com.studywithus.web.controller.study.studyboardreport;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.studywithus.config.jwt.JwtProperties;
import com.studywithus.domain.entity.study.StudyBoardReportCategory;
import com.studywithus.domain.service.study.studyboardreport.StudyBoardReportService;
import com.studywithus.domain.service.study.studyboardreport.dto.CreateStudyBoardReportDto;
import com.studywithus.web.controller.common.SuccessResult;
import com.studywithus.web.controller.study.studyboardreport.form.ResponseStudyBoardReportDto;
import com.studywithus.web.controller.study.studyboardreport.form.CreateStudyBoardReportForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudyBoardReportControllerImpl implements StudyBoardReportController{
    private final StudyBoardReportService studyBoardReportService;

    @GetMapping("studies/{studyId}/studyBoards/{studyBoardId}/Report")
    public SuccessResult isRecommendStudyBoard(HttpServletRequest request, @PathVariable Long studyId, @PathVariable Long studyBoardId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();
        Long result = studyBoardReportService.selectStudyBoardReport(verifyId, studyBoardId);

        if(result.equals(0L)){
            ResponseStudyBoardReportDto isReportStudyBoard = new ResponseStudyBoardReportDto(false);
            return new SuccessResult(isReportStudyBoard, "신고하지 않았습니다", "success");
        }
        ResponseStudyBoardReportDto isReportStudyBoard = new ResponseStudyBoardReportDto(true);
        return new SuccessResult(isReportStudyBoard, "이미 신고하였습니다.", "success");
    }


    @PostMapping("studies/{studyId}/studyBoards/{studyBoardId}/Report")
    public SuccessResult joinDropStudyBoardRecommend(HttpServletRequest request, @PathVariable Long studyId, @RequestBody @Validated CreateStudyBoardReportForm requestForm,
                                                     BindingResult bindingResult, @PathVariable Long studyBoardId) {
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            throw new IllegalArgumentException("입력 값이 잘못되었습니다!");
        }

        if(!requestForm.getStudyBoardReportCategory().equals("sensational") && !requestForm.getStudyBoardReportCategory().equals("commercial") && !requestForm.getStudyBoardReportCategory().equals("abuse") && !requestForm.getStudyBoardReportCategory().equals("ex")){
            throw new IllegalArgumentException("카테고리 값이 잘못되었습니다!");
        }

        CreateStudyBoardReportDto requestDto = new CreateStudyBoardReportDto(verifyId, studyBoardId, StudyBoardReportCategory.valueOf(requestForm.getStudyBoardReportCategory()));
        Long result = studyBoardReportService.joinDropStudyBoardReport(requestDto);

        if(result.equals(-1L)){
            ResponseStudyBoardReportDto isReportStudyBoard = new ResponseStudyBoardReportDto(true);
            return new SuccessResult(isReportStudyBoard, "신고를 완료하였습니다", "success");
        }
        ResponseStudyBoardReportDto isReportStudyBoard = new ResponseStudyBoardReportDto(true);
        return new SuccessResult(isReportStudyBoard, "이미 신고하였습니다!", "success");
    }
}
