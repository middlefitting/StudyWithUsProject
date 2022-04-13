package com.studywithus.web.controller.study.memberstudy;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.studywithus.config.jwt.JwtProperties;
import com.studywithus.domain.service.study.memberstudy.MemberStudyService;
import com.studywithus.web.controller.common.SuccessResult;
import com.studywithus.web.controller.study.memberstudy.dto.ResponseIsStudyMemberDto;
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
public class MemberStudyControllerImpl implements MemberStudyController{

    private final MemberStudyService memberStudyService;


    @GetMapping("/studies/{studyId}/memberStudies")
    public SuccessResult isStudyMember(HttpServletRequest request, @PathVariable Long studyId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        Long result = memberStudyService.selectStudyMember(verifyId, studyId);

        if(result.equals(0L)){
            ResponseIsStudyMemberDto isStudyMember = new ResponseIsStudyMemberDto(false);
            return new SuccessResult(isStudyMember, "스터디 멤버가 아닙니다", "success");
        }
        ResponseIsStudyMemberDto isStudyMember = new ResponseIsStudyMemberDto(true);
        return new SuccessResult(isStudyMember, "스터디 멤버입니다.", "success");
    }


    @PostMapping("/studies/{studyId}/memberStudies")
    public SuccessResult joinMemberStudy(HttpServletRequest request, @PathVariable Long studyId){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        DecodedJWT verify = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken);
        Long verifyId = verify.getClaim("id").asLong();

        Long result = memberStudyService.joinDropStudy(verifyId, studyId);

        if (result.equals(0L)){
            throw new RuntimeException();
        }
        else if(result.equals(-1L)){
            ResponseIsStudyMemberDto isStudyMember = new ResponseIsStudyMemberDto(false);
            return new SuccessResult(isStudyMember, "스터디 탈퇴 완료", "success");
        }
        ResponseIsStudyMemberDto isStudyMember = new ResponseIsStudyMemberDto(true);
        return new SuccessResult(isStudyMember, "스터디 가입 완료", "success");
    }
}
