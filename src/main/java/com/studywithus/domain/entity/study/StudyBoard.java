package com.studywithus.domain.entity.study;

import com.studywithus.domain.entity.BaseConstructorEntity;
import com.studywithus.domain.entity.member.Member;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_board")
@Getter
@Setter
@NoArgsConstructor
public class StudyBoard extends BaseConstructorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "study_board_id")
    private Long id;

    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    private StudyBoardCategory studyBoardCategory; //notice, study, free

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="study_id")
    private Study study;
    
    //작성자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy = "studyBoard", cascade = CascadeType.ALL)
    private List<StudyBoardComment> studyBoardComments = new ArrayList<>();
    @OneToMany(mappedBy = "studyBoard", cascade = CascadeType.ALL)
    private List<StudyBoardRecommend> studyBoardRecommends= new ArrayList<>();
    @OneToMany(mappedBy = "studyBoard", cascade = CascadeType.ALL)
    private List<StudyBoardReport> studyBoardReports = new ArrayList<>();
    @OneToMany(mappedBy = "studyBoard", cascade = CascadeType.ALL)
    private List<StudyBoardView> studyBoardViews = new ArrayList<>();
    @OneToMany(mappedBy = "studyBoard", cascade = CascadeType.ALL)
    private List<StudyBoardFileDir> studyBoardFileDirs = new ArrayList<>();


    public StudyBoard(String title, String content, StudyBoardCategory studyBoardCategory, Study study, Member member) {
        this.title = title;
        this.content = content;
        this.studyBoardCategory = studyBoardCategory;
        this.study = study;
        this.member = member;
    }
}
