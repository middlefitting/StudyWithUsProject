package com.studywithus.dto.member;

import lombok.Data;

@Data
public class CreateMemberResponseDto {
    private Long id;

    public CreateMemberResponseDto(Long id){
        this.id = id;
    }
}