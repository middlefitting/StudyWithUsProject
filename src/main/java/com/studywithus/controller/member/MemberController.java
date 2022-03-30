package com.studywithus.controller.member;
import com.studywithus.controller.member.dto.MemberDto;
import com.studywithus.domain.member.Member;
import com.studywithus.repository.member.MemberRepository;
import com.studywithus.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping("/member")
    public MemberDto.CreateMemberResponse saveMember(@RequestBody @Valid MemberDto.CreateMemberRequest request){
        Member member = new Member(request.getEmail(), request.getNickname(), request.getPassword(), request.getBornDate());
        //exception 걸기 필요
        Long id = memberService.join(member);
        return new MemberDto.CreateMemberResponse(id);
    }

}
