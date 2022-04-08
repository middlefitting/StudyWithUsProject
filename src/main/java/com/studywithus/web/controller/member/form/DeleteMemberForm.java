package com.studywithus.web.controller.member.form;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class DeleteMemberForm {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min=8, max=20)
    private String password;

    public DeleteMemberForm(){
    }

    @Builder
    public DeleteMemberForm(String email, String password) {
        this.email = email;
        this.password = password;
    }



}
