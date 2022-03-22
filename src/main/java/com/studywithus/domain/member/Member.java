package com.studywithus.domain.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
//    @Column(name = "mem_id")
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    private String password;
    private String bornDate;

    public Member() {
    }

    public Member Member(Member member){
        this.email = member.getEmail();
        this.nickname = member.getNickname();
        this.password = member.getPassword();
        this.bornDate = member.getBornDate();
        return member;
    }

    public Member(String email, String nickname, String password, String bornDate) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.bornDate = bornDate;
    }
}
