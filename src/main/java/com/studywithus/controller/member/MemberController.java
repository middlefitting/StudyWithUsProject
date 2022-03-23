package com.studywithus.controller.member;
import com.studywithus.dto.member.CreateMemberRequestDto;
import com.studywithus.dto.member.CreateMemberResponseDto;
import com.studywithus.repository.member.MemberJpaRepository;
import com.studywithus.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberJpaRepository memberJpaRepository;
    private final MemberService memberService;

    @PostMapping("/member")
    public CreateMemberResponseDto saveMember(@RequestBody @Valid CreateMemberRequestDto requestDto){
//        exception 걸기 필요
        Long id = memberService.join(requestDto);
        return new CreateMemberResponseDto(id);
    }


}
