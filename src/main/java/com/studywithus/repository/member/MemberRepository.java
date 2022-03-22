package com.studywithus.repository.member;

import com.studywithus.domain.board.Post;
import com.studywithus.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {
}
