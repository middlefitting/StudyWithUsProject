package com.studywithus.controller.member;
import com.querydsl.core.types.Order;
import com.studywithus.controller.member.dto.SelectMemberResponseDto;
import com.studywithus.controller.member.dto.SelectMembersDto;
import com.studywithus.domain.member.Member;
import com.studywithus.service.member.dto.CreateMemberRequestDto;
import com.studywithus.controller.member.dto.CreateMemberResponseDto;
import com.studywithus.repository.member.MemberRepository;
import com.studywithus.service.member.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping("/member")
    public CreateMemberResponseDto joinMember(@RequestBody @Valid CreateMemberRequestDto requestDto){
//        exception 걸기 필요
        Long id = memberService.join(requestDto);
        CreateMemberResponseDto responseDto = new CreateMemberResponseDto(id);
        return responseDto;
    }

    @GetMapping("/member")
    public Result selectAllMembers(){
//        exception 걸기 필요
        List<Member> members = memberService.selectAll();

        List<SelectMembersDto> result = members.stream()
                .map(o -> new SelectMembersDto(o))
                .collect(Collectors.toList());
        return new Result(result);
    }

    @GetMapping("/member/{id}") //인증정보가 있어야 함 //아무나 찾으면 안된다.
    public ResultWithId selectMember(@PathVariable("id") Long id){
        Member member = memberService.selectById(id).get();
        SelectMemberResponseDto returnDto = SelectMemberResponseDto.builder()
                .email(member.getEmail())
                .bornDate(member.getBornDate())
                .nickname(member.getNickname())
                .password(member.getPassword())
                .build();
        Long returnId = member.getId();

        return new ResultWithId(returnId , returnDto);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class ResultWithId<Long, T> {
        private Long id;
        private T data;
    }


}
