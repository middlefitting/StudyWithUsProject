package com.studywithus.web.controller.member;

import com.studywithus.web.controller.member.MemberController;
import com.studywithus.web.controller.member.dto.SelectMemberResponseDto;
import com.studywithus.web.controller.member.dto.SelectMembersDto;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.service.member.dto.CreateMemberRequestDto;
import com.studywithus.domain.repository.member.MemberRepository;
import com.studywithus.domain.service.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MemberService memberService;
    @MockBean
    private MemberRepository memberRepository;

    protected MediaType contentType =
            new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);

    @Test
    @DisplayName("회원가입 Controller")
    public void joinMemberPostContent() throws Exception{
        //given
        CreateMemberRequestDto requestDto = new CreateMemberRequestDto("wjdtmdcjf199@naver.com", "middleFitting", "@123middle","1996-06-25");
        given(memberService.join(any())).willReturn(1L);
        
        //when then
        mockMvc.perform(post("/member")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(
                                "{ \"email\" : \"wjdtmdcjf199@naver.com\", \"nickname\" : \"middleFitting\", \"password\": \"@123middle\", \"bornDate\": \"1996-06-25\"}"
                        ))
                .andExpect(status().isOk())  // 200 ok
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)) // json
                .andExpect(jsonPath("$.id").value(1));
//                .andExpect(jsonPath("$.code").value(ErrorCode.OK.getCode()))
//                .andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()));
        
    }

    @Test
    @DisplayName("회원 전체 조회 Controller")
    public void selectAllMembersGetContent() throws Exception{
        //given
        List<Member> members = CreateMemberEntityList();

        given(memberService.selectAll()).willReturn(members);
        //when
        List<SelectMembersDto> result = members.stream()
                .map(o -> new SelectMembersDto(o))
                .collect(Collectors.toList());
        MemberController.SuccessResult result1 = new MemberController.SuccessResult(result, "전체 회원정보 조회 완료", "success");

        //then
        mockMvc.perform(get("/member")
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data[0].id").value(members.get(0).getId()))
                .andExpect(jsonPath("$.data[0].email").value(members.get(0).getEmail()))
                .andExpect(jsonPath("$.data[0].nickname").value(members.get(0).getNickname()))
                .andExpect(jsonPath("$.data[0].password").value(members.get(0).getPassword()))
                .andExpect(jsonPath("$.data[0].bornDate").value(members.get(0).getBornDate()))
                .andExpect(jsonPath("$.data[1].id").value(members.get(1).getId()))
                .andExpect(jsonPath("$.data[1].email").value(members.get(1).getEmail()))
                .andExpect(jsonPath("$.data[1].nickname").value(members.get(1).getNickname()))
                .andExpect(jsonPath("$.data[1].password").value(members.get(1).getPassword()))
                .andExpect(jsonPath("$.data[1].bornDate").value(members.get(1).getBornDate()));
    }

    @Test
    @DisplayName("회원 단건 조회 Controller")
    public void selectMemberGetContent() throws Exception{
        //given
        Long id = 1L;
        Optional<Member> memberOptional = CreateMemberOptional();

        given(memberService.selectById(any())).willReturn(memberOptional);

        //when
        Member member = memberService.selectById(id).get();

        SelectMemberResponseDto returnDto = SelectMemberResponseDto.builder()
                .email(member.getEmail())
                .bornDate(member.getBornDate())
                .nickname(member.getNickname())
                .build();

        Long returnId = member.getId();
        MemberController.SuccessResult result = new MemberController.SuccessResult(returnDto, "회원정보 조회 완료", "success");

        //then
        mockMvc.perform(get("/member/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.data.email").value(member.getEmail()))
                .andExpect(jsonPath("$.data.nickname").value(member.getNickname()))
                .andExpect(jsonPath("$.data.password").value(member.getPassword()))
                .andExpect(jsonPath("$.data.bornDate").value(member.getBornDate()));
    }




    private List<Member> CreateMemberEntityList(){
        List<Member> members = new ArrayList<>();
        Member member1 = new Member(1L, "wjdtmdcjf@naver.com", "middleFitting", "@123middle", "1996-06-25");
        Member member2 = new Member(2L, "andy@gmail.com", "andy", "@123andy", "2000-12-31");
        members.add(member1);
        members.add(member2);
        return members;
    }

    private Member CreateMemberEntity(){
        Member member = new Member("wjdtmdcjf199@naver.com", "middleFitting","@123Middle", "1996-06-25");
        return  member;
    }

    private Optional<Member> CreateMemberOptional(){
        Member member = new Member(1L, "wjdtmdcjf199@naver.com", "middleFitting","@123Middle", "1996-06-25");
        return Optional.of(member);
    }
}