package com.studywithus.repository.board;

import com.studywithus.domain.board.P_like;
import com.studywithus.domain.board.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface P_likeRepository extends JpaRepository<P_like, Long>, QuerydslPredicateExecutor<P_like> {
}
