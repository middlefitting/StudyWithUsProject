package com.studywithus.domain.repository.board.C_like;

import org.springframework.data.repository.query.Param;

public interface C_likeRepositoryCustom {
    // Delete
    void deleteByCLikeId(@Param("like_id") Long like_id);
}
