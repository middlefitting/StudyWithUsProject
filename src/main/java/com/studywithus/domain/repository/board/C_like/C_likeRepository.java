package com.studywithus.domain.repository.board.C_like;

import com.studywithus.domain.entity.board.C_like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface C_likeRepository extends JpaRepository<C_like, Long>, C_likeRepositoryCustom {
}