package com.studywithus.repository.board;

import com.studywithus.domain.board.C_like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface C_likeRepository extends JpaRepository<C_like, Long>, QuerydslPredicateExecutor<C_like> {
}
