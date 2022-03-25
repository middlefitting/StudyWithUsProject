package com.studywithus.service.member;

import com.studywithus.domain.member.Member;
import com.studywithus.service.member.dto.CreateMemberRequestDto;
import com.studywithus.repository.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void testJoin() throws Exception{
        //given
        CreateMemberRequestDto requestDto = createMemberRequestDto();
        Member member = CreateMemberEntity(requestDto);

        Long fakeMemberId = 1L;
        ReflectionTestUtils.setField(member, "id", fakeMemberId);

        //mocking
        given(memberRepository.save(any())).willReturn(member);
        given(memberRepository.findById(fakeMemberId)).willReturn(Optional.ofNullable(member));

        //when
        Long returnId = memberService.join(requestDto);

        //then
        Member findMember = memberRepository.findById(returnId).get();
        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
        Assertions.assertThat(member.getEmail()).isEqualTo(findMember.getEmail());
        Assertions.assertThat(member.getNickname()).isEqualTo(findMember.getNickname());
        Assertions.assertThat(member.getBornDate()).isEqualTo(findMember.getBornDate());
        Assertions.assertThat(member.getPassword()).isEqualTo(findMember.getPassword());
    }

    @Test
    public void testSelectAll() throws Exception{

    }

    private Member CreateMemberEntity(CreateMemberRequestDto requestDto){
        return Member.builder()
                .email(requestDto.getEmail())
                .nickname(requestDto.getNickname())
                .password(requestDto.getPassword())
                .bornDate(requestDto.getBornDate())
                .build();
    }

    private CreateMemberRequestDto createMemberRequestDto(){
        CreateMemberRequestDto requestDto = new CreateMemberRequestDto();
        requestDto.setEmail("wjdtmdcjf199@naver.com");
        requestDto.setNickname("middleFitting");
        requestDto.setPassword("@123middle");
        requestDto.setBornDate("1996-06-25");
        return  requestDto;
    }

}