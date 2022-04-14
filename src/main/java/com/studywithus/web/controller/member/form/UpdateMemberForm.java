package com.studywithus.web.controller.member.form;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UpdateMemberForm {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min=1, max=20)
    private String nickname;
    @NotBlank
    @Length(min=10, max=10)
    private String bornDate;

    public UpdateMemberForm(){
    }

    @Builder
    public UpdateMemberForm(String email, String nickname, String bornDate) {
        this.email = email;
        this.nickname = nickname;
        this.bornDate = bornDate;
    }



}
