package com.studywithus.controller.member;

import com.studywithus.dto.member.CreateMemberRequestDto;
import com.studywithus.repository.member.MemberJpaRepository;
import com.studywithus.service.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.nio.charset.StandardCharsets;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MemberController.class)
class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MemberService memberService;
    @MockBean
    private MemberJpaRepository memberJpaRepository;

    protected MediaType contentType =
            new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);

    @Test
    @DisplayName("회원가입")
    public void saveMemberPostContent() throws Exception{
        //given
        CreateMemberRequestDto requestDto = new CreateMemberRequestDto("wjdtmdcjf199@naver.com", "middleFitting", "@123middle","1996-06-25");
        given(memberService.join(any())).willReturn(1L);
        
        //when then
        mockMvc.perform(post("/member")                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(
                                "{ \"email\" : \"wjdtmdcjf199@naver.com\", \"nickname\" : \"middleFitting\", \"password\": \"@123middle\", \"bornDate\": \"1996-06-25\"}"
                        ))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
//                .andExpect(jsonPath("$.code").value(ErrorCode.OK.getCode()))
//                .andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()));
        
    }

}