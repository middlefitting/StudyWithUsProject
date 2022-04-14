package com.studywithus.domain.repository.study.study;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studywithus.domain.entity.study.Study;
import com.studywithus.domain.repository.study.study.dto.QStudyDto;
import com.studywithus.domain.repository.study.study.dto.StudyDto;
import com.studywithus.domain.repository.study.study.dto.StudyPageSearchCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static com.studywithus.domain.entity.member.QMember.*;
import static com.studywithus.domain.entity.study.QStudy.study;
import static org.springframework.util.StringUtils.hasText;

@Slf4j
public class StudyRepositoryImpl implements StudyRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public StudyRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    private OrderSpecifier<?> studySort(Pageable pageable) {
        if (!pageable.getSort().isEmpty()) {
            for (Sort.Order order : pageable.getSort()) {
                Order direction = order.getDirection().isAscending() ? Order.ASC : Order.DESC;
                switch (order.getProperty()){
                    case "regDate":
                        return new OrderSpecifier(direction, study.regDate);
                    case "studyMemberCount":
                        return new OrderSpecifier(direction, study.studyMemberCount);
                    default:
                        return new OrderSpecifier(direction, study.regDate);
                }
            }
        }
        return null;
    }


    public Page<StudyDto> searchStudyPage(Pageable pageable, StudyPageSearchCondition condition) {

        List<StudyDto> content = queryFactory
                .select(new QStudyDto(study.id, study.regDate, study.studyName, study.studyExplanation, study.member.nickname, study.studyMemberCount))
                .from(study)
                .where(study.id.goe(0L), masterNicknameContains(condition.getMasterNickname()),
                        studyExplanationContains(condition.getStudyExplanation()), studyNameContains(condition.getStudyName()))
                .orderBy(studySort(pageable))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPAQuery<Study> countQuery = queryFactory
                .select(study)
                .from(study)
                .where(study.id.goe(0L), masterNicknameContains(condition.getMasterNickname()),
                        studyExplanationContains(condition.getStudyExplanation()), studyNameContains(condition.getStudyName()));
        return PageableExecutionUtils.getPage(content, pageable, () -> countQuery.fetch().size());
    }

    public Optional<Long> searchStudyByMember(Long memberId){
        return Optional.ofNullable(queryFactory
                .select(study.member.id)
                .from(study)
                .where(study.member.id.eq(memberId))
                .fetchOne());
    }


    public Optional<Study> searchStudyByIdFetch(Long studyId){
        return Optional.ofNullable(queryFactory
                .select(study)
                .from(study)
                .join(study.member, member).fetchJoin()
                .where(study.id.eq(studyId))
                .fetchOne());
    }

    private BooleanExpression masterNicknameContains(String masterNickname) {
        return hasText(masterNickname) ?  study.member.nickname.contains(masterNickname) : null;
    }
    private BooleanExpression studyExplanationContains(String studyExplanation) {
        return hasText(studyExplanation) ?  study.studyExplanation.contains(studyExplanation) : null;
    }
    private BooleanExpression studyNameContains(String studyName) {
        return hasText(studyName) ?  study.studyName.contains(studyName) : null;
    }
}
