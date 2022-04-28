package com.studywithus.domain.entity.study;

import com.studywithus.domain.entity.BaseConstructorEntity;
import com.studywithus.domain.entity.member.Member;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudyBoard extends BaseConstructorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "study_board_id")
    private Long id;

    private String title;
    private String content;
    private Long studyBoardCommentCount = 0L;
    private Long studyBoardRecommendCount = 0L;
    private Long studyBoardReportCount = 0L;
    private Long studyBoardViewCount = 0L;

    @Enumerated(EnumType.STRING)
    private StudyBoardCategory studyBoardCategory; //notice, study, free

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="study_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
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

    public void updateStudyBoard(String title, String content, StudyBoardCategory studyBoardCategory){
        this.title = title;
        this.content = content;
        this.studyBoardCategory = studyBoardCategory;
    }

    public void studyBoardCommentCountPlus(){
        this.studyBoardCommentCount +=1;
    }
    public void studyBoardCommentCountMinus(){
        this.studyBoardCommentCount -=1;
    }
    public void studyBoardRecommendCountPlus(){
        this.studyBoardRecommendCount +=1;
    }
    public void studyBoardRecommendCountMinus(){
        this.studyBoardRecommendCount -=1;
    }
    public void studyBoardReportCountPlus(){
        this.studyBoardReportCount +=1;
    }
    public void studyBoardViewCountPlus(){
        this.studyBoardViewCount +=1;
    }
}
