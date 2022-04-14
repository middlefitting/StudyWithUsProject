package com.studywithus.domain.entity.study;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.studywithus.domain.entity.member.Member;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "study_board_view")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class StudyBoardView {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "study_board_view_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="study_board_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudyBoard studyBoard;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    public StudyBoardView(StudyBoard studyBoard, Member member) {
        this.studyBoard = studyBoard;
        this.member = member;
    }
}
