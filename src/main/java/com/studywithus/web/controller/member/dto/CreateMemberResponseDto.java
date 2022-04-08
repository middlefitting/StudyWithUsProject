package com.studywithus.web.controller.member.dto;

import lombok.Data;

@Data
public class CreateMemberResponseDto {
    private String status;

    public CreateMemberResponseDto(String status){
        this.status = status;
    }
}
