package com.studywithus.web.controller.board.dto;

import lombok.Data;

@Data
public class CreatePostResponseDto {
    private Long id;

    public CreatePostResponseDto(Long id){
        this.id = id;
    }
}
