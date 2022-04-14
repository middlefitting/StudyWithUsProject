package com.studywithus.domain.repository.study.studyboard;

import com.querydsl.core.types.Operation;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import com.studywithus.domain.entity.study.StudyBoard;
import com.studywithus.domain.entity.study.StudyBoardCategory;

import com.studywithus.domain.repository.study.studyboard.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static com.studywithus.domain.entity.member.QMember.*;
import static com.studywithus.domain.entity.study.QStudyBoard.*;
import static org.springframework.util.StringUtils.hasText;

public class StudyBoardRepositoryImpl implements StudyBoardRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public StudyBoardRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    private OrderSpecifier<?> studyBoardSort(Pageable pageable) {
        if (!pageable.getSort().isEmpty()) {
            for (Sort.Order order : pageable.getSort()) {
                Order direction = order.getDirection().isAscending() ? Order.ASC : Order.DESC;
                switch (order.getProperty()){
                    case "regDate":
                        return new OrderSpecifier(direction, studyBoard.regDate);
                    case "StudyBoardCommentCount":
                        return new OrderSpecifier(direction, studyBoard.studyBoardCommentCount);
                    case "StudyBoardRecommendCount":
                        return new OrderSpecifier(direction, studyBoard.studyBoardRecommendCount);
                    case "StudyBoardViewCount":
                        return new OrderSpecifier(direction, studyBoard.studyBoardViewCount);
                    default:
                        return new OrderSpecifier(direction, studyBoard.regDate);
                }
            }
        }
        return null;
    }


    public Page<StudyBoardDto> searchStudyBoardPage(Pageable pageable, StudyBoardPageSearchCondition condition) {

        List<StudyBoardDto> content = queryFactory
                .select(new QStudyBoardDto(studyBoard.id, studyBoard.study.id, studyBoard.member.id, studyBoard.regDate, studyBoard.member.nickname, studyBoard.title,
                        studyBoard.content, studyBoard.studyBoardCategory, studyBoard.studyBoardCommentCount, studyBoard.studyBoardRecommendCount, studyBoard.studyBoardReportCount, studyBoard.studyBoardViewCount))
                .from(studyBoard)
                .where(studyBoard.id.goe(0L), studyBoardWriterNicknameContains(condition.getStudyBoardWriterNickname()),
                        studyBoardTitleContains(condition.getStudyBoardTitle()), studyBoardContentContains(condition.getStudyBoardContent()),
                        studyBoardCategoryEq(condition.getStudyBoardCategory()), studyBoardStudyIdEq(condition.getStudyId()))
                .orderBy(studyBoardSort(pageable))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPAQuery<StudyBoard> countQuery = queryFactory
                .select(studyBoard)
                .from(studyBoard)
                .where(studyBoard.id.goe(0L), studyBoardWriterNicknameContains(condition.getStudyBoardWriterNickname()),
                        studyBoardTitleContains(condition.getStudyBoardTitle()), studyBoardContentContains(condition.getStudyBoardContent()),
                        studyBoardCategoryEq(condition.getStudyBoardCategory()), studyBoardStudyIdEq(condition.getStudyId()));
        return PageableExecutionUtils.getPage(content, pageable, () -> countQuery.fetch().size());
    }


    public Optional<StudyBoardSingleDto> searchStudyBoardSingle(Long id) {

        return Optional.ofNullable(queryFactory
                .select(new QStudyBoardSingleDto(studyBoard.id, studyBoard.content, studyBoard.title, studyBoard.member.nickname, studyBoard.regDate,
                        studyBoard.studyBoardCommentCount, studyBoard.studyBoardRecommendCount, studyBoard.studyBoardReportCount, studyBoard.studyBoardViewCount))
                .from(studyBoard)
                .where(studyBoard.id.eq(id))
                .fetchOne());
    }


    public Optional<StudyBoard> searchStudyBoardByBoardAndMemberId(Long memberId, Long boardId) {
        return Optional.ofNullable(queryFactory
                .selectFrom(studyBoard)
                .join(studyBoard.member, member).fetchJoin()
                .where(member.id.eq(memberId).and(studyBoard.id.eq(boardId)))
                .fetchOne());
    }


    private BooleanExpression studyBoardWriterNicknameContains(String studyBoardWriterNickname) {
        return hasText(studyBoardWriterNickname) ?  studyBoard.member.nickname.contains(studyBoardWriterNickname) : null;
    }
    private BooleanExpression studyBoardTitleContains(String studyBoardTitle) {
        return hasText(studyBoardTitle) ?  studyBoard.title.contains(studyBoardTitle) : null;
    }
    private BooleanExpression studyBoardContentContains(String studyBoardContent) {
        return hasText(studyBoardContent) ?  studyBoard.content.contains(studyBoardContent) : null;
    }
    private BooleanExpression studyBoardStudyIdEq(Long studyId) {
        return studyId!=null ?  studyBoard.study.id.eq(studyId) : null;
    }
    private BooleanExpression studyBoardCategoryEq(String category) {
        if (category.equals("notice") || category.equals("study") || category.equals("free")) {
            return studyBoard.studyBoardCategory.eq(StudyBoardCategory.valueOf(category));
        }
        return null;
    }






}
