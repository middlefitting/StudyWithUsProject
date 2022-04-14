package com.studywithus.web.controller.study.study;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.studywithus.config.jwt.JwtProperties;
import com.studywithus.domain.entity.study.Study;
import com.studywithus.domain.repository.study.Study.dto.StudyDto;
import com.studywithus.domain.repository.study.Study.dto.StudyPageSearchCondition;
import com.studywithus.domain.service.study.study.StudyService;
import com.studywithus.domain.service.study.study.dto.CreateStudyDto;
import com.studywithus.domain.service.study.study.dto.UpdateStudyDto;
import com.studywithus.web.controller.common.SuccessResult;
import com.studywithus.web.controller.study.study.dto.GetStudyResponseDto;
import com.studywithus.web.controller.study.study.form.CreateStudyForm;
import com.studywithus.web.controller.study.study.form.UpdateStudyForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudyControllerImpl implements StudyController{

    private final StudyService studyService;

    @GetMapping("/studies") //?page=0&size=5&sort=firstname&sort=lastname,asc.
    public SuccessResult selectStudies(HttpServletRequest request, @PageableDefault(size = 10, page = 0, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable,
                                       StudyPageSearchCondition condition){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Page<StudyDto> pageResults = studyService.selectStudyPage(pageable, condition);
        return new SuccessResult(pageResults, "페이지 정보 반환 완료", "success");
    }

    @PostMapping("/studies")
    public SuccessResult createStudy(HttpServletRequest request, @RequestBody @Validated CreateStudyForm requestForm, BindingResult bindingResult){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();
        
        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            throw new IllegalArgumentException("입력 값이 잘못되었습니다!");
        }

        CreateStudyDto requestDto = new CreateStudyDto(requestForm.getStudyName(), requestForm.getStudyExplanation(), verifyId);

        //전부다 RuntimeException이 뜨는데 수정이 필요할듯
        Long Studyid = studyService.createStudy(requestDto);
        if (Studyid.equals(0L)){
            throw new IllegalArgumentException("스터디 생성 실패");
        }

        return new SuccessResult("", "스터디 생성 완료", "success");
    }


    @GetMapping("/studies/{studyId}")
    public SuccessResult getStudy(HttpServletRequest request, @PathVariable Long studyId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        //전부다 RuntimeException이 뜨는데 수정이 필요할듯
        Optional<Study> studyOptional = studyService.getStudy(studyId);
        Study study = studyOptional.get();
        GetStudyResponseDto responseDto = GetStudyResponseDto.builder()
                .studyId(study.getId())
                .studyMasterId(study.getMember().getId())
                .studyName(study.getStudyName())
                .studyExplanation(study.getStudyExplanation())
                .studyMemberCount(study.getStudyMemberCount())
                .studyMasterNickname(study.getMember().getNickname())
                .regDate(study.getRegDate())
                .build();

        return new SuccessResult(responseDto, "스터디 정보 반환 완료", "success");
    }


    //스터디 정보 수정
    @PutMapping("/studies/{studyId}")
    public SuccessResult updateStudy(HttpServletRequest request, @PathVariable Long studyId, @RequestBody @Validated UpdateStudyForm requestForm, BindingResult bindingResult){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            throw new IllegalArgumentException("입력 값이 잘못되었습니다!");
        }

        UpdateStudyDto requestDto = new UpdateStudyDto(studyId, requestForm.getStudyName(), requestForm.getStudyExplanation(), verifyId);

        //전부다 RuntimeException이 뜨는데 수정이 필요할듯
        Long Studyid = studyService.updateStudy(requestDto);

        return new SuccessResult("", "스터디 수정 완료", "success");
    }


    @DeleteMapping("/studies/{studyId}")
    public SuccessResult deleteStudy(HttpServletRequest request, @PathVariable Long studyId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        //전부다 RuntimeException이 뜨는데 수정이 필요할듯
        studyService.deleteStudy(studyId, verifyId);

        return new SuccessResult("", "스터디 삭제 완료", "success");
    }




}
