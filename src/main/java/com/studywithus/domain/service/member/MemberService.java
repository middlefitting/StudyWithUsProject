package com.studywithus.domain.service.member;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.service.member.dto.CreateMemberRequestDto;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Optional<String> duplicateEmail(String email);

    Optional<String> duplicateNickname(String nickname);

    Long join(CreateMemberRequestDto requestDto);

    Optional<Member> selectByEmail(String email);

    Member updateMember(CreateMemberRequestDto requestDto);

    String deleteMember(String email);

    String updateMemberPassword(CreateMemberRequestDto requestDto);

    List<Member> selectAll();
}
