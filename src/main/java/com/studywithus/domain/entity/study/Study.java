package com.studywithus.domain.entity.study;

import com.studywithus.domain.entity.BaseConstructorEntity;
import com.studywithus.domain.entity.member.Member;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study")
@Getter
@Setter
@NoArgsConstructor
public class Study extends BaseConstructorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "study_id")
    private Long id;

    private String studyName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

//    @Column(columnDefinition = "CHAR(1) default '1'")
    private boolean isPublic;

    private String studyExplanation;

    @OneToMany(mappedBy = "study", cascade = CascadeType.ALL)
    private List<MemberStudy> memberStudies = new ArrayList<>();

    @OneToMany(mappedBy = "study", cascade = CascadeType.ALL)
    private List<StudyBoard> studyBoards = new ArrayList<>();



    public Study(String studyName, Member member, boolean isPublic, String studyExplanation) {
        this.studyName = studyName;
        this.member = member;
        this.isPublic = isPublic;
        this.studyExplanation = studyExplanation;
    }
}