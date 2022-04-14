//package com.studywithus.domain.repository.study.study;
//
//import com.querydsl.core.Tuple;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQuery;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.studywithus.domain.entity.study.Study;
//import com.studywithus.domain.entity.study.StudyBoardCategory;
//
//import com.studywithus.domain.repository.study.Study.StudyRepository;
//import com.studywithus.domain.repository.study.Study.dto.QStudyDto;
//import com.studywithus.domain.repository.study.Study.dto.StudyDto;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.support.PageableExecutionUtils;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//
//import java.util.List;
//
//import static com.studywithus.domain.entity.study.QStudy.*;
//import static com.studywithus.domain.entity.study.QStudyBoard.*;
//import static com.studywithus.domain.entity.study.QStudyBoardComment.*;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.springframework.util.StringUtils.hasText;
//
//@SpringBootTest
//@Transactional
//class StudyRepositoryTest {
//    @Autowired
//    EntityManager em;
//    @Autowired
//    StudyRepository studyRepository;
//    JPAQueryFactory queryFactory;
//
//    @BeforeEach
//    public void before() {
//        queryFactory = new JPAQueryFactory(em);
//    }
//
//    @Test
//    public void test() throws Exception{
//        List<Tuple> fetch = queryFactory
//                .select(study.id, study.regDate,study.studyName, study.studyExplanation, study.member.nickname, study.member.id)
//                .from(study)
//                .orderBy(study.regDate.asc())
//                .offset(5)
//                .limit(5)
//                .fetch();
//        for (Tuple tuple : fetch) {
//            System.out.println(tuple.get(study.member.id));
//        }
//        assertThat(fetch.size()).isEqualTo(5);
//
//    }
//
//    @Test
//    public void test2() throws Exception{
//        List<StudyDto> fetch = queryFactory
//                .select(new QStudyDto(study.id, study.regDate,study.studyName, study.studyExplanation, study.member.nickname, study.member.id))
//                .from(study)
//                .orderBy(study.regDate.asc())
//                .offset(5)
//                .limit(5)
//                .fetch();
//        for (StudyDto studyDto : fetch) {
//            System.out.println(studyDto.getMemberId());
//        }
//        assertThat(fetch.size()).isEqualTo(5);
//    }
//
//
//    @Test
//    public void test3() throws Exception{
//        Pageable pageRequest = PageRequest.of(0,5);
//        List<StudyDto> content = queryFactory
//                .select(new QStudyDto(study.id, study.regDate,study.studyName, study.studyExplanation, study.member.nickname, study.member.id))
//                .from(study)
//                .orderBy(study.regDate.asc())
//                .offset(pageRequest.getOffset())
//                .limit(pageRequest.getPageSize())
//                .fetch();
//        JPAQuery<Study> countQuery = queryFactory
//                .select(study)
//                .from(study);
//        //버전 1
//        long total = countQuery.fetch().size();
//        PageImpl<StudyDto> pp = new PageImpl<>(content, pageRequest, total);
//        //업그레이드 버전//마지막 페이지거나 페이지 수보다 count 작으면 쿼리 안날림
//        Page<StudyDto> pageUpgrade = PageableExecutionUtils.getPage(content, pageRequest, () -> countQuery.fetch().size());
//
//
//        for (StudyDto studyDto : content) {
//            System.out.println(studyDto.getMemberId());
//        }
//        System.out.println(total);
//        assertThat(content.size()).isEqualTo(5);
//    }
//
//
//    @Test
//    public void test4() throws Exception{
//        List<Tuple> fetch = queryFactory
//                .select(studyBoardComment.studyBoard.id, studyBoardComment.studyBoard.id.count())
//                .from(studyBoardComment)
//                .groupBy(studyBoardComment.studyBoard.id)
//                .fetch();
//        for (Tuple tuple : fetch) {
//            System.out.println(tuple.get(studyBoardComment.studyBoard.id) + ":" + tuple.get(studyBoardComment.studyBoard.id.count()));
//        }
////        assertThat(fetch.size()).isEqualTo(5);
//    }
//
//
//
//
//    @Test
//    public void test100() throws Exception{
//        Long aLong = queryFactory
//                .select(study.count())
//                .from(study)
//                .fetchOne();
//        assertThat(aLong).isEqualTo(10);
////        notice, study, free
//
//    }
//
//    private BooleanExpression usernameEq(String username) {
//        if(username!="notice" && username!="study" && username!="free"){
//            return null;
//        }
//        return studyBoard.studyBoardCategory.eq(StudyBoardCategory.valueOf(username));
////        return hasText(username) ?  QStudyBoard.studyBoard.studyBoardCategory.eq(StudyBoardCategory.valueOf(username)) : null;
//    }
//}