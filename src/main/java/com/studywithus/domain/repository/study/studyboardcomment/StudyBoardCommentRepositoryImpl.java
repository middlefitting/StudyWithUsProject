package com.studywithus.domain.repository.study.studyboardcomment;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studywithus.domain.entity.study.QStudyBoard;
import com.studywithus.domain.entity.study.QStudyBoardComment;
import com.studywithus.domain.entity.study.StudyBoard;
import com.studywithus.domain.entity.study.StudyBoardComment;
import com.studywithus.domain.repository.study.studyboard.dto.QStudyBoardSingleDto;
import com.studywithus.domain.repository.study.studyboardcomment.dto.QStudyBoardCommentDto;
import com.studywithus.domain.repository.study.studyboardcomment.dto.StudyBoardCommentDto;
import com.studywithus.domain.repository.study.studyboardcomment.dto.StudyBoardCommentSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static com.studywithus.domain.entity.study.QStudyBoard.studyBoard;
import static com.studywithus.domain.entity.study.QStudyBoardComment.*;

public class StudyBoardCommentRepositoryImpl implements StudyBoardCommentRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public StudyBoardCommentRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    private OrderSpecifier<?> studyBoardCommentSort(Pageable pageable) {
        if (!pageable.getSort().isEmpty()) {
            for (Sort.Order order : pageable.getSort()) {
                Order direction = order.getDirection().isAscending() ? Order.ASC : Order.DESC;
                switch (order.getProperty()){
                    case "regDate":
                        return new OrderSpecifier(direction, studyBoardComment.regDate);
                    case "StudyBoardCommentRecommendCount":
                        return new OrderSpecifier(direction, studyBoardComment.studyBoardCommentRecommendCount);
                    default:
                        return new OrderSpecifier(direction, studyBoardComment.regDate);
                }
            }
        }
        return null;
    }

    public Page<StudyBoardCommentDto> searchStudyBoardComment(Pageable pageable, Long studyBoardId){
        List<StudyBoardCommentDto> content = queryFactory
                .select(new QStudyBoardCommentDto(studyBoardComment.id, studyBoardComment.studyBoard.id, studyBoardComment.member.id,
                        studyBoardComment.member.nickname, studyBoardComment.content, studyBoardComment.studyBoardCommentRecommendCount,
                        studyBoardComment.studyBoardCommentReportCount, studyBoardComment.regDate))
                .from(studyBoardComment)
                .where(studyBoardComment.studyBoard.id.eq(studyBoardId))
                .orderBy(studyBoardCommentSort(pageable))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPAQuery<StudyBoardComment> countQuery = queryFactory
                .select(studyBoardComment)
                .from(studyBoardComment)
                .where(studyBoardComment.studyBoard.id.eq(studyBoardId))
                .orderBy(studyBoardCommentSort(pageable))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());
        return PageableExecutionUtils.getPage(content, pageable, () -> countQuery.fetch().size());
    }

    public Optional<String> searchStudyBoardCommentSingleContent(Long memberId, Long studyBoardCommentId){
        return Optional.ofNullable(queryFactory
                .select(studyBoardComment.content)
                .from(studyBoardComment)
                .where(studyBoardComment.id.eq(studyBoardCommentId).and(studyBoardComment.member.id.eq(memberId)))
                .fetchOne());
    }













}
