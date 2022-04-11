package com.studywithus.domain.repository.board.P_like;

import com.querydsl.core.Tuple;
import com.studywithus.domain.entity.board.P_like;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface P_likeRepositoryCustom {

    // 구현할 메서드 명세 작성
    List<Tuple> getP_like(@Param("post_id") Long post_id);
}
