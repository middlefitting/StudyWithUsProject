package com.studywithus.web.controller.member;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.studywithus.config.jwt.JwtProperties;
import com.studywithus.web.controller.member.form.CreateMemberForm;
import com.studywithus.web.controller.member.dto.SelectMemberResponseDto;
import com.studywithus.web.controller.member.dto.SelectMembersDto;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.service.member.dto.CreateMemberRequestDto;
import com.studywithus.domain.service.member.MemberService;
import com.studywithus.web.controller.member.form.DeleteMemberForm;
import com.studywithus.web.controller.member.form.UpdateMemberForm;
import com.studywithus.web.controller.member.form.UpdateMemberPasswordForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {
    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/join")
    public SuccessResult joinMember(@RequestBody @Validated CreateMemberForm requestForm, BindingResult bindingResult){

        //exception
        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            throw new IllegalArgumentException("입력 값이 잘못되었습니다!");
        }

        Optional<String> email = memberService.duplicateEmail(requestForm.getEmail());
        String duplicateEmail = email.orElseGet(()->"");
        if(duplicateEmail != ""){
            throw new IllegalArgumentException("중복된 이메일입니다!");
        }

        Optional<String> nickname = memberService.duplicateNickname(requestForm.getNickname());
        String duplicateNickname = nickname.orElseGet(()->"");
        if(duplicateNickname != ""){
            throw new IllegalArgumentException("중복된 닉네임입니다!");
        }

        //success
        String rawPassword = requestForm.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        CreateMemberRequestDto requestDto = new CreateMemberRequestDto(requestForm.getEmail(), requestForm.getNickname(), encPassword, requestForm.getBornDate());
        
        //try catch로 만약 동시 회원가입이 되면 중복이니 중복 던질 수 있게 하라 //아니면 내부서버 오류 뜨면 잠시 후 다시 시작해 달라 하라
        Long id = memberService.join(requestDto);
//        CreateMemberResponseDto responseDto = new CreateMemberResponseDto("success");
        return new SuccessResult("", "회원가입 완료", "success");
    }


    @GetMapping("/member") //jwt 토큰 기반으로 찾음
    public SuccessResult selectMember(HttpServletRequest request){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        String email = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken).getClaim("email").asString();
        Member memberResult = memberService.selectByEmail(email).get();

        SelectMemberResponseDto returnDto = SelectMemberResponseDto.builder()
                .email(memberResult.getEmail())
                .nickname(memberResult.getNickname())
                .bornDate(memberResult.getBornDate())
                .build();
//        Long returnId = memberResult.getId();

        return new SuccessResult(returnDto, "회원정보 조회 완료", "success");
    }


    @PutMapping("/member") //jwt 토큰 기반으로 찾음
    public SuccessResult updateMember(HttpServletRequest request, @RequestBody @Validated UpdateMemberForm requestForm, BindingResult bindingResult){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        String email = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken).getClaim("email").asString();

        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            throw new IllegalArgumentException("입력 값이 잘못되었습니다!");
        }

        if(!Objects.equals(email, requestForm.getEmail())){
            throw new RuntimeException();
        }

        Optional<String> nickname = memberService.duplicateNickname(requestForm.getNickname());
        String duplicateNickname = nickname.orElseGet(()->"");
        if(duplicateNickname != ""){
            throw new IllegalArgumentException("중복된 닉네임입니다!");
        }

        CreateMemberRequestDto requestDto = new CreateMemberRequestDto(requestForm.getEmail(), requestForm.getNickname(), requestForm.getBornDate());
        Member memberResult = memberService.updateMember(requestDto);

        SelectMemberResponseDto returnDto = SelectMemberResponseDto.builder()
                .email(memberResult.getEmail())
                .nickname(memberResult.getNickname())
                .bornDate(memberResult.getBornDate())
                .build();
        Long returnId = memberResult.getId();

        return new SuccessResult(returnDto, "회원정보 수정 완료", "success");
    }


    @DeleteMapping("/member")
    public SuccessResult deleteMember(HttpServletRequest request, @RequestBody @Validated DeleteMemberForm requestForm, BindingResult bindingResult){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        String email = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken).getClaim("email").asString();

        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            throw new IllegalArgumentException("입력 값이 잘못되었습니다!");
        }

        if(!Objects.equals(email, requestForm.getEmail())){
            throw new RuntimeException();
        }

        Member memberResult = memberService.selectByEmail(email).get();
        if (!bCryptPasswordEncoder.matches(requestForm.getPassword(), memberResult.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다!");
        }

        String result = memberService.deleteMember(requestForm.getEmail());
        if(result == "success"){
            return new SuccessResult("", "회원삭제 완료", "success");
        }
        return new SuccessResult("", "회원삭제 실패", "failed");
    }


    @PostMapping("/member")
    public SuccessResult updateMemberPassword(HttpServletRequest request, @RequestBody @Validated UpdateMemberPasswordForm requestForm, BindingResult bindingResult){
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");
        String email = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken).getClaim("email").asString();

        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            throw new IllegalArgumentException("입력 값이 잘못되었습니다!");
        }

        if(!Objects.equals(email, requestForm.getEmail())){
            throw new RuntimeException();
        }

        Member memberResult = memberService.selectByEmail(email).get(); //이거 한번에 할지 서비스에서 따로 처리할지 고민
        if (!bCryptPasswordEncoder.matches(requestForm.getPassword(), memberResult.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다!");
        }

        String rawPassword = requestForm.getNewPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        System.out.println(encPassword);
        CreateMemberRequestDto requestDto = new CreateMemberRequestDto(requestForm.getEmail(), encPassword);
        
        String result = memberService.updateMemberPassword(requestDto);
        if(result == "success"){
            return new SuccessResult("", "회원 비밀번호 변경 완료", "success");
        }
        return new SuccessResult("", "회원 비밀번호 변경 실패", "failed");

    }


    @GetMapping("/manager/member")
    public SuccessResult selectAllMembers(){
        List<Member> members = memberService.selectAll();
        List<SelectMembersDto> result = members.stream()
                .map(o -> new SelectMembersDto(o))
                .collect(Collectors.toList());
        return new SuccessResult(result, "전체 회원정보 조회 완료", "success");
    }


    @Data
    @AllArgsConstructor
    static class SuccessResult<T> {
        private T data;
        private String message;
        private String status;
    }


}
