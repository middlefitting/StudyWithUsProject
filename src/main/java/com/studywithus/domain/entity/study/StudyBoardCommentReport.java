package com.studywithus.domain.entity.study;

import com.studywithus.domain.entity.BaseConstructorEntity;
import com.studywithus.domain.entity.member.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "study_board_comment_report")
@Getter
@Setter
@NoArgsConstructor
public class StudyBoardCommentReport extends BaseConstructorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "study_board_comment_report_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private StudyBoardCommentReportCategory studyBoardCommentReportCategory; //sensational, commercial, abuse, ex

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="study_board_comment_id")
    private StudyBoardComment studyBoardComment;


    public StudyBoardCommentReport(StudyBoardCommentReportCategory studyBoardCommentReportCategory, Member member, StudyBoardComment studyBoardComment) {
        this.studyBoardCommentReportCategory = studyBoardCommentReportCategory;
        this.member = member;
        this.studyBoardComment = studyBoardComment;
    }
}
