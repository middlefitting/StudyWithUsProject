package com.studywithus.service.member;

import com.studywithus.domain.member.Member;
import com.studywithus.service.member.MemberService;
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

import java.util.ArrayList;
import java.util.List;
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
    @DisplayName("회원가입 Service")
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
    @DisplayName("회원 전체 조회 Service")
    public void testSelectAll() throws Exception{
        //given
        CreateMemberRequestDto requestDto = createMemberRequestDto();
        Member member = CreateMemberEntity(requestDto);
        CreateMemberRequestDto requestDto2 = createMemberRequestDto2();
        Member member2 = CreateMemberEntity(requestDto2);

        Long fakeMemberId = 1L;
        ReflectionTestUtils.setField(member, "id", fakeMemberId);
        Long fakeMemberId2 = 2L;
        ReflectionTestUtils.setField(member2, "id", fakeMemberId2);

        List<Member> members = new ArrayList<>();
        members.add(member);
        members.add(member2);


        //mocking//when
        given(memberRepository.findAll()).willReturn(members);

        //then
        List<Member> findMembers = memberRepository.findAll();
        for(int i=0; i<2; i++){
            Assertions.assertThat(members.get(i).getId()).isEqualTo(findMembers.get(i).getId());
            Assertions.assertThat(members.get(i).getEmail()).isEqualTo(findMembers.get(i).getEmail());
            Assertions.assertThat(members.get(i).getNickname()).isEqualTo(findMembers.get(i).getNickname());
            Assertions.assertThat(members.get(i).getBornDate()).isEqualTo(findMembers.get(i).getBornDate());
            Assertions.assertThat(members.get(i).getPassword()).isEqualTo(findMembers.get(i).getPassword());
        }
    }



    @Test
    @DisplayName("회원 단건 조회 Service")
    public void testSelectById() throws Exception{
        //given
        CreateMemberRequestDto requestDto = createMemberRequestDto();
        Member member = CreateMemberEntity(requestDto);
        Long fakeMemberId = 1L;
        ReflectionTestUtils.setField(member, "id", fakeMemberId);
        Optional<Member> memberOptional = Optional.ofNullable(member);

        //mocking//when
        given(memberRepository.findById(fakeMemberId)).willReturn(memberOptional);

        //then
        Optional<Member> memberFind = memberRepository.findById(fakeMemberId);
        Optional<Member> MemberReturn = Optional.of(memberFind.orElseGet(Member::new));

        Assertions.assertThat(MemberReturn.get().getId()).isEqualTo(member.getId());
        Assertions.assertThat(MemberReturn.get().getEmail()).isEqualTo(member.getEmail());
        Assertions.assertThat(MemberReturn.get().getNickname()).isEqualTo(member.getNickname());
        Assertions.assertThat(MemberReturn.get().getBornDate()).isEqualTo(member.getBornDate());
        Assertions.assertThat(MemberReturn.get().getPassword()).isEqualTo(member.getPassword());


        /////////////////////////////////NullTest/////////////////////////////////////////////////////
        Optional<Member> memberOptionalNull = Optional.ofNullable(null);

        given(memberRepository.findById(any())).willReturn(memberOptionalNull);
        Optional<Member> memberNullFind = memberRepository.findById(fakeMemberId);
        Optional<Member> MemberNullReturn = Optional.of(memberNullFind.orElseGet(Member::new));

        Assertions.assertThat(MemberNullReturn.get().getId()).isEqualTo(null);
        Assertions.assertThat(MemberNullReturn.get().getEmail()).isEqualTo(null);
        Assertions.assertThat(MemberNullReturn.get().getNickname()).isEqualTo(null);
        Assertions.assertThat(MemberNullReturn.get().getBornDate()).isEqualTo(null);
        Assertions.assertThat(MemberNullReturn.get().getPassword()).isEqualTo(null);

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

    private CreateMemberRequestDto createMemberRequestDto2(){
        CreateMemberRequestDto requestDto = new CreateMemberRequestDto();
        requestDto.setEmail("min123@naver.com");
        requestDto.setNickname("happy");
        requestDto.setPassword("@123min");
        requestDto.setBornDate("2000-02-22");
        return  requestDto;
    }

}