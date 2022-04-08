package com.studywithus.web.controller.member.dto;

import com.studywithus.domain.entity.member.Member;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SelectMemberResponseDto {
    @NotEmpty
    private String email;
    @NotEmpty
    private String nickname;
    @NotEmpty
//        @DateTimeFormat(pattern = "yyyy-MM-dd")
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private String bornDate;

    public SelectMemberResponseDto(){
    }
    @Builder
    public SelectMemberResponseDto(String email, String nickname, String bornDate) {
        this.email = email;
        this.nickname = nickname;
        this.bornDate = bornDate;
    }

    public Member toEntity(){
        return Member.builder()
                .email(email)
                .nickname(nickname)
                .bornDate(bornDate).build();
    }


}
