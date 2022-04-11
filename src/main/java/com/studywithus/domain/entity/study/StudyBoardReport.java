package com.studywithus.domain.entity.study;

import com.studywithus.domain.entity.BaseConstructorEntity;
import com.studywithus.domain.entity.member.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "study_board_report")
@Getter
@Setter
@NoArgsConstructor
public class StudyBoardReport extends BaseConstructorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "study_board_report_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private StudyBoardReportCategory studyBoardReportCategory; //sensational, commercial, abuse, ex


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="study_board_id")
    private StudyBoard studyBoard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    public StudyBoardReport(StudyBoardReportCategory studyBoardReportCategory, StudyBoard studyBoard, Member member) {
        this.studyBoardReportCategory = studyBoardReportCategory;
        this.studyBoard = studyBoard;
        this.member = member;
    }
}
