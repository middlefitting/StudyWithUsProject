package com.studywithus.domain.repository.member;

import com.studywithus.domain.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
//    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);
//    List<Member> findByUsername(@Param("username") String username); //: jpql 있으면 네임드 어노테이션 파람이 넘어가야 한다
    public Optional<Member> findByEmail(String email);
    public Optional<Member> findByNickname(String nickname);
    public void deleteMemberByEmail(String email);
}