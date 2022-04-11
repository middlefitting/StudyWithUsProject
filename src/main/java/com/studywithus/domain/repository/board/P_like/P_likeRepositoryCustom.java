package com.studywithus.domain.repository.board.P_like;

import org.springframework.data.repository.query.Param;

public interface P_likeRepositoryCustom {
    // Delete
    void deleteByPLikeId(@Param("like_id") Long like_id);
}
