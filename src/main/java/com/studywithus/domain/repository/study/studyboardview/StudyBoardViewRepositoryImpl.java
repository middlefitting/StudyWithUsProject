package com.studywithus.domain.repository.study.studyboardview;

import com.querydsl.core.annotations.QueryInit;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.member.QMember;
import com.studywithus.domain.entity.study.QStudyBoard;
import com.studywithus.domain.entity.study.QStudyBoardView;
import com.studywithus.domain.entity.study.StudyBoardView;
import org.springframework.web.servlet.tags.form.OptionsTag;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;

import java.util.List;
import java.util.Optional;

import static com.studywithus.domain.entity.member.QMember.*;
import static com.studywithus.domain.entity.study.QStudyBoard.*;
import static com.studywithus.domain.entity.study.QStudyBoardView.*;

public class StudyBoardViewRepositoryImpl implements StudyBoardViewRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public StudyBoardViewRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

//    public Optional<Integer> findStudyBoardViews(Long studyBoardId){
//        return Optional.of(queryFactory
//                .selectFrom(studyBoardView.count())
//                .leftJoin(studyBoardView.studyBoard, studyBoard).fetchJoin()
//                .where(studyBoardView.studyBoard.id.eq(studyBoardId))
//                .fetch());
//    }

    public List<StudyBoardView> findStudyBoardViews(Long studyBoardId){
        return queryFactory
                .select(studyBoardView)
                .from(studyBoardView)
                .join(studyBoardView.studyBoard, studyBoard).fetchJoin()
//                .join(studyBoardView.member, member).fetchJoin()
                .where(studyBoardView.studyBoard.id.eq(studyBoardId))
//                .where(studyBoardView.member.id.eq(1L))
                .fetch();
    }

    public List<Long> findStudyBoardViews2(){
        return queryFactory
                .select(studyBoardView.id)
                .from(studyBoardView)
//                .join(studyBoardView.studyBoard, studyBoard).fetchJoin()
//                .join(studyBoardView.member, member).fetchJoin()
//                .where(studyBoardView.studyBoard.id.eq(studyBoardId))
//                .where(studyBoardView.member.id.eq(1L))
                .fetch();
    }
}
