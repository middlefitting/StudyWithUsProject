package com.studywithus.domain.service.study.memberstudy;

public interface MemberStudyService {
    public Long joinDropStudy(Long memberId, Long StudyId);
    Long selectStudyMember(Long memberId, Long StudyId);
}
