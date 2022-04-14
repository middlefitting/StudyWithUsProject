package com.studywithus.web.controller.member.form;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UpdateMemberPasswordForm {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min=8, max=20)
    private String password;
    @NotBlank
    @Length(min=8, max=20)
    private String newPassword;

    public UpdateMemberPasswordForm(){
    }

    @Builder
    public UpdateMemberPasswordForm(String email, String password, String newPassword) {
        this.email = email;
        this.password = password;
        this.newPassword = newPassword;
    }



}
