package com.studywithus.domain.member;

import com.studywithus.domain.BaseConstructorEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Member extends BaseConstructorEntity {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;
    private String password;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private String bornDate;

    public Member() {
    }

    public void UpdateMember(Member member){
        this.email = member.getEmail();
        this.nickname = member.getNickname();
        this.password = member.getPassword();
        this.bornDate = member.getBornDate();
    }

    @Builder
    public Member(String email, String nickname, String password, String bornDate) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.bornDate = bornDate;
    }

    public Member(Long id, String email, String nickname, String password, String bornDate) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.bornDate = bornDate;
    }
}
