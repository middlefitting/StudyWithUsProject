package com.studywithus.domain.member;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long mem_id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    private String password;
    private String bornDate;

//    public Member() {
//    }
//
//    public Member Member(Member member){
//        this.email = member.getEmail();
//        this.nickname = member.getNickname();
//        this.password = member.getPassword();
//        this.bornDate = member.getBornDate();
//        return member;
//    }
//
//    public Member(String email, String nickname, String password, String bornDate) {
//        this.email = email;
//        this.nickname = nickname;
//        this.password = password;
//        this.bornDate = bornDate;
//    }
}
