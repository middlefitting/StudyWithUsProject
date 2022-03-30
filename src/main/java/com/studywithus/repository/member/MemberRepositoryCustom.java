package com.studywithus.repository.member;

import com.studywithus.domain.member.Member;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepositoryCustom {
    // 구현할 메서드 명세 작성
//    void save(Member member);
//    Member findById(@Param("mem_id") Long id);
    List<Member> findByEmailPassword(@Param("email") String email, @Param("password") String password);
    List<Member> findByEmail(@Param("email") String email);
    List<Member> findAll();
}
