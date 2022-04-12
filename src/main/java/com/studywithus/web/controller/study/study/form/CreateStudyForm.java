package com.studywithus.web.controller.study.study.form;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class CreateStudyForm {
    @NotBlank
    private String studyName;
    @NotBlank
    @Length(min=10, max=20)
    private String studyExplanation;
//    @NotBlank
//    private Long memberId;

    public CreateStudyForm(){
    }

}
