package com.studywithus.domain.entity.study;

import com.studywithus.domain.entity.BaseConstructorEntity;
import com.studywithus.domain.entity.member.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Study_board_comment_recommend")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudyBoardCommentRecommend extends BaseConstructorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Study_board_comment_recommend_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="study_board_comment_id")
    private StudyBoardComment studyBoardComment;

    public StudyBoardCommentRecommend(Member member, StudyBoardComment studyBoardComment) {
        this.member = member;
        this.studyBoardComment = studyBoardComment;
    }
}
