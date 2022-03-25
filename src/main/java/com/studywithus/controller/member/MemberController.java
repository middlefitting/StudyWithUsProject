package com.studywithus.controller.member;
import com.querydsl.core.types.Order;
import com.studywithus.controller.member.dto.SelectMembersDto;
import com.studywithus.domain.member.Member;
import com.studywithus.service.member.dto.CreateMemberRequestDto;
import com.studywithus.controller.member.dto.CreateMemberResponseDto;
import com.studywithus.repository.member.MemberRepository;
import com.studywithus.service.member.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
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

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }


}
