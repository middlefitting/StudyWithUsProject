package com.studywithus.domain.repository.board.P_like;

import com.studywithus.domain.entity.board.P_like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface P_likeRepository extends JpaRepository<P_like, Long>, P_likeRepositoryCustom {
}
