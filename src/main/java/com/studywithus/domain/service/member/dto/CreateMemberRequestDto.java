package com.studywithus.domain.service.member.dto;

import com.studywithus.domain.entity.member.Member;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateMemberRequestDto {
    @NotEmpty
    private String email;
    @NotEmpty
    private String nickname;
    @NotEmpty
    private String password;
    @NotEmpty
//        @DateTimeFormat(pattern = "yyyy-MM-dd")
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private String bornDate;

    public CreateMemberRequestDto(){
    }
    @Builder
    public CreateMemberRequestDto(String email, String nickname, String password, String bornDate) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.bornDate = bornDate;
    }

    public CreateMemberRequestDto(String email, String nickname, String bornDate) {
        this.email = email;
        this.nickname = nickname;
        this.bornDate = bornDate;
    }

    public CreateMemberRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Member toEntity(){
        return Member.builder()
                .email(email)
                .nickname(nickname)
                .password(password)
                .bornDate(bornDate).build();
    }


}
