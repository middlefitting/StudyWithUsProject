package com.studywithus.web.controller.member.form;

import com.studywithus.domain.entity.member.Member;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
public class CreateMemberForm {
    @NotBlank //공백 무시
    @Email
    private String email;
    @NotBlank
    @Length(min=1, max=20)
    private String nickname;
    @NotBlank
    @Length(min=8, max=20)
    private String password;
    @NotBlank
    @Length(min=10, max=10)
    private String bornDate;

    public CreateMemberForm(){
    }

    @Builder
    public CreateMemberForm(String email, String nickname, String password, String bornDate) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.bornDate = bornDate;
    }



}
