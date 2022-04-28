package com.studywithus.domain.entity.study;

import com.studywithus.domain.entity.BaseConstructorEntity;
import com.studywithus.domain.entity.member.Member;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Study extends BaseConstructorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "study_id")
    private Long id;
//    @Column(columnDefinition = "CHAR(1) default '1'")
    private Long studyMemberCount = 0L;
    private String studyName;
    private String studyExplanation;
    private boolean isPublic;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id", unique = true)
    private Member member;



    @OneToMany(mappedBy = "study", cascade = CascadeType.REMOVE, orphanRemoval=true)
    private List<MemberStudy> memberStudies = new ArrayList<>();

    @OneToMany(mappedBy = "study", cascade = CascadeType.REMOVE, orphanRemoval=true)
    private List<StudyBoard> studyBoards = new ArrayList<>();



    public Study(String studyName, Member member, boolean isPublic, String studyExplanation) {
        this.studyName = studyName;
        this.member = member;
        this.isPublic = isPublic;
        this.studyExplanation = studyExplanation;
    }

    public Study(String studyName, String studyExplanation) {
        this.studyName = studyName;
        this.studyExplanation = studyExplanation;
    }

    public void studyMemberCountPlus(){
        this.studyMemberCount +=1;
    }
    public void studyMemberCountMinus(){
        this.studyMemberCount -=1;
    }
    public void updateStudyEntity(String studyName, String studyExplanation){
        this.studyName = studyName;
        this.studyExplanation = studyExplanation;
    }
}