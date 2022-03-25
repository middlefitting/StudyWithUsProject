package com.studywithus.repository.board.p_like;

import com.studywithus.domain.board.P_like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface P_likeRepository extends JpaRepository<P_like, Long>, P_likeRepositoryCustom {
}
