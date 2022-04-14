package com.studywithus.domain.entity.study;

import com.studywithus.domain.entity.BaseConstructorEntity;
import com.studywithus.domain.entity.BaseEntity;
import com.studywithus.domain.entity.member.Member;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="member_study")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberStudy extends BaseConstructorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_study_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_id")
    private Study study;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public MemberStudy(Study study, Member member) {
        this.study = study;
        this.member = member;
    }


}