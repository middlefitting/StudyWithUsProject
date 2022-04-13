package com.studywithus.web.controller.study.studyboardcomment.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class CreateStudyBoardCommentForm {
    @NotBlank
    @Length(min=10, max=100)
    private String content;
}
