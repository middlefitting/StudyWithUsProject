package com.studywithus.domain.repository.jwt;

import com.studywithus.domain.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JwtMemberRepository extends JpaRepository<Member, Long> {
    public Optional<Member> findByEmail(String email);
    public Optional<Member> findByNickname(String nickname);
}