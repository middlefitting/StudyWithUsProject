package com.studywithus.web.controller.study.memberstudy.dto;

import lombok.Data;

@Data
public class ResponseIsStudyMemberDto {
    private boolean isStudyMember;

    public ResponseIsStudyMemberDto(boolean isStudyMember) {
        this.isStudyMember = isStudyMember;
    }
}
