package com.studywithus;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.member.QMember;
import com.studywithus.domain.entity.study.QStudyBoard;
import com.studywithus.domain.entity.study.QStudyBoardComment;
import com.studywithus.domain.entity.study.StudyBoardView;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.studywithus.domain.entity.member.QMember.*;
import static com.studywithus.domain.entity.study.QStudyBoard.*;
import static com.studywithus.domain.entity.study.QStudyBoardComment.*;
import static com.studywithus.domain.entity.study.QStudyBoardView.studyBoardView;

@SpringBootTest
@Transactional
public class basic {

    @PersistenceContext
    EntityManager em;

    JPAQueryFactory queryFactory;

    @BeforeEach
    public void before() {
        queryFactory = new JPAQueryFactory(em);
    }

    @Test
    public void test() throws Exception{
        List<StudyBoardView> fetch = queryFactory
                .select(studyBoardView)
                .from(studyBoardView)
                .fetch();
        System.out.println(fetch);
    }

    @Test
    public void test2() throws Exception{
        Member member1 = new Member("2memberTest@naver.com","n2icknameTest", "@1234567890", "2000-01-01");
        em.persist(member1);
        Member fetch = queryFactory
                .select(member)
                .from(member)
                .where(member.nickname.eq("n2icknameTest"))
                .fetchOne();
        System.out.println(fetch);
    }

    @Test
    public void test3() throws Exception{
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

    @Test
    public void test4() throws Exception{
        Member member1 = new Member("2memberTest@naver.com","n2icknameTest", "@1234567890", "2000-01-01");
        em.persist(member1);

        List<Tuple> countComment = queryFactory
                .select(studyBoard.id, ExpressionUtils.as(JPAExpressions
                        .select(studyBoardComment.count())
                        .from(studyBoardComment)
                        .where(studyBoardComment.studyBoard.id.eq(studyBoard.id)), "countComment"))
                .from(studyBoard)
                .fetch();

        for (Tuple tuple : countComment) {
            System.out.println(tuple.get(studyBoard.id));

        }
    }



    @Test
    public void test5() throws Exception{

        List<Long> fetch = queryFactory.select(studyBoardComment.studyBoard.id.count())
                .from(studyBoardComment)
                .join(studyBoardComment.studyBoard, studyBoard)
                .fetchJoin()
                .where(studyBoardComment.studyBoard.id.eq(studyBoard.id))
                .groupBy(studyBoard.id)
                .fetch();

        for (Long aLong : fetch) {
            System.out.println(aLong);
        }
    }


    @Test
    public void test6() throws Exception{

        List<Tuple> fetch = queryFactory.select(studyBoardComment.studyBoard.id, studyBoardComment.studyBoard.id.count())
                .from(studyBoardComment)
                .join(studyBoardComment.studyBoard, studyBoard)
//                .fetchJoin()
                .where(studyBoardComment.studyBoard.id.eq(studyBoard.id))
                .groupBy(studyBoard.id)
                .fetch();
        System.out.println("=============================================================");
        for (Tuple tuple : fetch) {
            System.out.println(tuple.get(studyBoardComment.studyBoard.id) + " : " + tuple.get(studyBoardComment.studyBoard.id.count()));
        }
    }


    @Test
    public void test7() throws Exception{

        List<Tuple> fetch = queryFactory.select(studyBoard.id, studyBoard.content, studyBoardComment.studyBoard.id, studyBoardComment.studyBoard.id.count())
                .from(studyBoard, studyBoardComment)
                .leftJoin(studyBoardComment.studyBoard, studyBoard).on(studyBoard.id.eq(studyBoard.id))
//                .fetchJoin()
                .groupBy(studyBoard.id)
                .fetch();
        System.out.println("=============================================================");
        for (Tuple tuple : fetch) {
            System.out.println(tuple.get(studyBoard.id) + tuple.get(studyBoard.content) +" : " + tuple.get(studyBoardComment.studyBoard.id.count()));
        }
    }


    @Test
//    @EntityGraph(attributePaths = {"studyBoardComment"})
    public void test8() throws Exception{

        List<Tuple> fetch = queryFactory.select(studyBoard.id, studyBoard.content,
                JPAExpressions
                                .select(studyBoardComment.id.count())
                                .from(studyBoardComment)
                                .where(studyBoardComment.studyBoard.id.eq(studyBoard.id))
                        )
                .from(studyBoard)
//                .join(studyBoardComment.studyBoard, studyBoard).on(studyBoard.id.eq(studyBoard.id))
//                .fetchJoin()
//                .groupBy(studyBoard.id)
                .fetch();
        System.out.println("=============================================================");
        for (Tuple tuple : fetch) {
//            System.out.println(tuple.get(studyBoard.id) + tuple.get(studyBoard.content) +" : " + tuple.get(studyBoardComment.id.count()));
            System.out.println(tuple);
        }
    }


    @Test
    @EntityGraph(attributePaths = {"studyBoardComment"})
    public void test9() throws Exception{

        JPAQuery<Tuple> on = queryFactory.select(studyBoard.id, studyBoard.content,
                        JPAExpressions
                                .select(studyBoardComment.studyBoard.id.count())
                                .from(studyBoardComment)
                                .where(studyBoardComment.studyBoard.id.eq(studyBoard.id))
                )
                .from(studyBoard)
                .join(studyBoardComment.studyBoard, studyBoard).on(studyBoardComment.studyBoard.id.eq(studyBoard.id));
        //.leftJoin(member.team, team).on(team.name.eq("teamA"))
//                .fetchJoin()
//                .groupBy(studyBoard.id)
//                .fetch();
        System.out.println("=============================================================");
//        for (Tuple tuple : fetch) {
////            System.out.println(tuple.get(studyBoard.id) + tuple.get(studyBoard.content) +" : " + tuple.get(studyBoardComment.id.count()));
//            System.out.println(tuple);
//        }
    }



}

