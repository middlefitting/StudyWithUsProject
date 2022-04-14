package com.studywithus.domain.repository.study.memberstudy;

import java.util.Optional;

public interface MemberStudyRepositoryCustom {
    Optional<Long> findByMemberIdAndStudyId(Long memberId, Long studyId);
}
