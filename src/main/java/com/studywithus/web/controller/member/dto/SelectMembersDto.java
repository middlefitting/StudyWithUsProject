package com.studywithus.web.controller.member.dto;

import com.studywithus.domain.entity.member.Member;
import lombok.Data;

@Data
public class SelectMembersDto {
    private Long id;
    private String email;
    private String nickname;
    private String password;
    private String bornDate;

    public SelectMembersDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.nickname = member.getNickname();
        this.password = member.getPassword();
        this.bornDate = member.getBornDate();
    }
}
