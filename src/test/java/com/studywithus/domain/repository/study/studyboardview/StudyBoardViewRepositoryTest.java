package com.studywithus.domain.repository.study.studyboardview;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.study.StudyBoardView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static com.studywithus.domain.entity.member.QMember.member;
import static com.studywithus.domain.entity.study.QStudyBoard.studyBoard;
import static com.studywithus.domain.entity.study.QStudyBoardView.studyBoardView;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class StudyBoardViewRepositoryTest {
    @Autowired
    EntityManager em;
    @Autowired
    StudyBoardViewRepository studyBoardViewRepository;

    @Test
    public void test2() throws Exception{
//        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        System.out.println(studyBoardViewRepository.findStudyBoardViews(211L));
    }

    @Test
    public void test3() throws Exception{
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        Member member1 = new Member("2memberTest@naver.com","n2icknameTest", "@1234567890", "2000-01-01");
        em.persist(member1);
        List<StudyBoardView> fetch = queryFactory
                .select(studyBoardView)
                .from(studyBoardView)
                .join(studyBoardView.studyBoard, studyBoard).fetchJoin()
//                .join(studyBoardView.member, member).fetchJoin()
                .where(studyBoardView.studyBoard.id.eq(211L))
//                .where(studyBoardView.member.id.eq(1L))
                .fetch();
        System.out.println("=============" + fetch.size());
    }
}