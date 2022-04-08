package com.studywithus.domain.entity.member;

import com.studywithus.domain.entity.BaseConstructorEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private String roles;
    private String provider;
    private String providerId;
//    @CreationTimestamp //Base와 중복
//    private Timestamp createDate;
    @CreationTimestamp //로그인 될 때마다 초기화?
    private Timestamp lastLoginDate;


//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private String bornDate;

    public Member() {
    }

    public void updateMember(String nickname, String bornDate){
        this.nickname = nickname;
        this.bornDate = bornDate;
    }

    public void updatePassword(String email, String password){
        this.password = password;
    }

    public Member(String email, String nickname, String password, String bornDate) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.bornDate = bornDate;
    }

    @Builder
    public Member(Long id, String email, String nickname, String password, String roles, String provider, String providerId, String bornDate) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.provider = provider;
        this.providerId = providerId;
        this.roles = roles;
        this.bornDate = bornDate;
    }

    public Member(Long id, String email, String nickname, String password, String bornDate) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.bornDate = bornDate;
    }

    public List<String> getRoleList(){
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
}
