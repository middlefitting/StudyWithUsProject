package com.studywithus.domain.entity.study;

import com.studywithus.domain.entity.BaseConstructorEntity;
import com.studywithus.domain.entity.member.Member;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="study_board_recommend")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudyBoardRecommend extends BaseConstructorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "study_board_recommend_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="study_board_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudyBoard studyBoard;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="member_id")
    private Member member;


    public StudyBoardRecommend(StudyBoard studyBoard, Member member) {
        this.studyBoard = studyBoard;
        this.member = member;
    }
}
