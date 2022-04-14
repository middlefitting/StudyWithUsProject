package com.studywithus.web.controller.jwt.dto;

import lombok.Data;

@Data
public class JwtLoginResponseDto {
    private String nickname;
    private Long id;
    private String email;

    public JwtLoginResponseDto(Long id, String email, String nickname) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
    }
}
