//package com.studywithus;
//
//import com.querydsl.jpa.impl.JPAQuery;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.studywithus.domain.entity.member.Member;
//import com.studywithus.domain.entity.member.QMember;
//import com.studywithus.domain.entity.study.QStudyBoard;
//import com.studywithus.domain.entity.study.StudyBoardView;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//import static com.studywithus.domain.entity.member.QMember.*;
//import static com.studywithus.domain.entity.study.QStudyBoard.*;
//import static com.studywithus.domain.entity.study.QStudyBoardView.studyBoardView;
//
//@SpringBootTest
//@Transactional
//public class basic {
//
//    @PersistenceContext
//    EntityManager em;
//
//    JPAQueryFactory queryFactory;
//
//    @BeforeEach
//    public void before() {
//        queryFactory = new JPAQueryFactory(em);
//    }
//
//    @Test
//    public void test() throws Exception{
//        List<StudyBoardView> fetch = queryFactory
//                .select(studyBoardView)
//                .from(studyBoardView)
//                .fetch();
//        System.out.println(fetch);
//    }
//
//    @Test
//    public void test2() throws Exception{
//        Member member1 = new Member("2memberTest@naver.com","n2icknameTest", "@1234567890", "2000-01-01");
//        em.persist(member1);
//        Member fetch = queryFactory
//                .select(member)
//                .from(member)
//                .where(member.nickname.eq("n2icknameTest"))
//                .fetchOne();
//        System.out.println(fetch);
//    }
//
//    @Test
//    public void test3() throws Exception{
//        Member member1 = new Member("2memberTest@naver.com","n2icknameTest", "@1234567890", "2000-01-01");
//        em.persist(member1);
//        List<StudyBoardView> fetch = queryFactory
//                .select(studyBoardView)
//                .from(studyBoardView)
//                .join(studyBoardView.studyBoard, studyBoard).fetchJoin()
////                .join(studyBoardView.member, member).fetchJoin()
//                .where(studyBoardView.studyBoard.id.eq(211L))
////                .where(studyBoardView.member.id.eq(1L))
//                .fetch();
//        System.out.println("=============" + fetch.size());
//    }
//
//
//}
//
