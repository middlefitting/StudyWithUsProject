package com.studywithus.domain.entity.member;

import com.studywithus.domain.entity.BaseConstructorEntity;
import com.studywithus.domain.entity.study.MemberStudy;
import com.studywithus.domain.entity.study.Study;
import com.studywithus.domain.entity.study.StudyBoard;
import com.studywithus.domain.entity.study.StudyBoardComment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter @Setter
@Table(name="member")
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

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Study study;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberStudy> memberStudies = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<StudyBoardComment> studyBoardComments = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<StudyBoard> studyBoards = new ArrayList<>();

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

    public Member(String email, String nickname, String password, String bornDate, String roles) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.bornDate = bornDate;
        this.roles = roles;
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

//    public List<String> getRoleList(){
//        if(this.roles!=null){
//            if (this.roles.length() > 0) {
//                return Arrays.asList(this.roles.split(","));
//            }
//        }
//        return new ArrayList<>();
//    }
}
