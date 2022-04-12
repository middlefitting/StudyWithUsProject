package com.studywithus.web.controller.initentiry;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.study.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Profile("local")
@Component
@RequiredArgsConstructor
public class InitMember {
    private final InitMemberService initMemberService;
    @PostConstruct
    public void init() {
        initMemberService.init();
    }
    @Component
    static class InitMemberService {
        @PersistenceContext
        EntityManager em;
        @Transactional
        public void init(){
            //Member
            List<Member> memberList = new ArrayList<>();
            for(int i=0; i<100; i++){
                Member member = new Member("memberTest" + i+ "@naver.com","nicknameTest" + i, "@1234567890", "2000-01-01", "ROLE_USER");
                em.persist(member);
                memberList.add(member);
            }

            //Study
            List<Study> studyList = new ArrayList<>();
            for(int i=0; i<10; i++){
                Study study = new Study("study" + i, memberList.get(i), true, "스터디입니다");
                em.persist(study);
                studyList.add(study);
            }

            //MemberStudy
            List<MemberStudy> memberStudyList = new ArrayList<>();
            for(int i=0; i<10; i++){
                for(int j=0; j<10; j++){
                    MemberStudy memberStudy = new MemberStudy(studyList.get(i), memberList.get(i*10+j));
                    em.persist(memberStudy);
                    memberStudyList.add(memberStudy);
                }
            }

            //StudyBoard
            List<StudyBoard> studyBoardList = new ArrayList<>();
            for(int i=0; i<10; i++){
                for(int j=0; j<10; j++){
                    if(j%4==0){
                        StudyBoard studyBoard = new StudyBoard("스터디"+i+ "게시글"+(j), "자바" + (i*10+j)+ "제일 쉬웠어요",
                                StudyBoardCategory.free, studyList.get(i), memberList.get(i*10+j));
                        em.persist(studyBoard);
                        studyBoardList.add(studyBoard);
                    }
                    if(j%4==1){
                        StudyBoard studyBoard = new StudyBoard("스터디"+i+ "게시글"+(j), "자바" + (i*10+j)+ "제일 쉬웠어요",
                                StudyBoardCategory.notice, studyList.get(i), memberList.get(i*10+j));
                        em.persist(studyBoard);
                        studyBoardList.add(studyBoard);
                    }
                    if(j%4==2){
                        StudyBoard studyBoard = new StudyBoard("스터디"+i+ "게시글"+(j), "자바" + (i*10+j)+ "제일 쉬웠어요",
                                StudyBoardCategory.study, studyList.get(i), memberList.get(i*10+j));
                        em.persist(studyBoard);
                        studyBoardList.add(studyBoard);
                    }
                    if(j%4==3){
                        StudyBoard studyBoard = new StudyBoard("스터디"+i+ "게시글"+(j), "자바" + (i*10+j)+ "제일 쉬웠어요",
                                StudyBoardCategory.free, studyList.get(i), memberList.get(i*10+j));
                        em.persist(studyBoard);
                        studyBoardList.add(studyBoard);
                    }
                }
            }



            //StudyBoardComment 1000개제한..
            List<StudyBoardComment> studyBoardCommentList = new ArrayList<>();
            for(int i=0; i<100; i++){
                for(int j=0; j<8; j++){
                    StudyBoardComment studyBoardComment = new StudyBoardComment("댓글테스트"+(j*10+i),studyBoardList.get(i), memberList.get((i/10)*10+j));
                    em.persist(studyBoardComment);
                    studyBoardCommentList.add(studyBoardComment);
                }
            }
            em.persist(new StudyBoardComment("댓글테스트추가",studyBoardList.get(0), memberList.get(0)));
            em.persist(new StudyBoardComment("댓글테스트추가",studyBoardList.get(0), memberList.get(0)));
            em.persist(new StudyBoardComment("댓글테스트추가",studyBoardList.get(0), memberList.get(0)));
            em.persist(new StudyBoardComment("댓글테스트추가",studyBoardList.get(0), memberList.get(0)));
            em.persist(new StudyBoardComment("댓글테스트추가",studyBoardList.get(1), memberList.get(2)));
            em.persist(new StudyBoardComment("댓글테스트추가",studyBoardList.get(1), memberList.get(3)));
            em.persist(new StudyBoardComment("댓글테스트추가",studyBoardList.get(1), memberList.get(4)));
            em.persist(new StudyBoardComment("댓글테스트추가",studyBoardList.get(1), memberList.get(7)));
            em.persist(new StudyBoardComment("댓글테스트추가",studyBoardList.get(2), memberList.get(7)));
            em.persist(new StudyBoardComment("댓글테스트추가",studyBoardList.get(2), memberList.get(6)));


            //StudyBoardCommentRecommend
            List<StudyBoardCommentRecommend> studyBoardCommentRecommendList = new ArrayList<>();
            for(int i=0; i<100; i++){
                for(int j=0; j<8; j++){
                    StudyBoardCommentRecommend studyBoardCommentRecommend = new StudyBoardCommentRecommend(memberList.get((i/10)*10+j), studyBoardCommentList.get(i));
                    em.persist(studyBoardCommentRecommend);
                    studyBoardCommentRecommendList.add(studyBoardCommentRecommend);
                }
            }

            //StudyBoardCommentReport
            List<StudyBoardCommentReport> studyBoardCommentReportList = new ArrayList<>();
            for(int i=0; i<100; i++){
                for(int j=0; j<8; j++){
                    StudyBoardCommentReport studyBoardCommentReport = new StudyBoardCommentReport(StudyBoardCommentReportCategory.sensational, memberList.get((i/10)*10+j), studyBoardCommentList.get(i));
                    em.persist(studyBoardCommentReport);
                    studyBoardCommentReportList.add(studyBoardCommentReport);
                }
            }



            //StudyBoardReport
            List<StudyBoardReport> studyBoardReportList = new ArrayList<>();
            for(int i=0; i<100; i++){
                StudyBoardReport studyBoardReport = new StudyBoardReport(StudyBoardReportCategory.abuse, studyBoardList.get(i), memberList.get(i));
                em.persist(studyBoardReport);
                studyBoardReportList.add(studyBoardReport);
                }

            //StudyBoardReport
            List<StudyBoardRecommend> studyBoardRecommendList = new ArrayList<>();
            for(int i=0; i<100; i++){
                StudyBoardRecommend studyBoardRecommend = new StudyBoardRecommend(studyBoardList.get(i), memberList.get(i));
                em.persist(studyBoardRecommend);
                studyBoardRecommendList.add(studyBoardRecommend);
            }

            //StudyBoardReport
            List<StudyBoardView> studyBoardViewList = new ArrayList<>();
            for(int i=0; i<100; i++){
                for(int j=0; j<5; j++){
                    if(i+j<100){
                        StudyBoardView studyBoardView = new StudyBoardView(studyBoardList.get(i), memberList.get(i+j));
                        em.persist(studyBoardView);
                        studyBoardViewList.add(studyBoardView);
                    }
                }
            }




        }
    }
}