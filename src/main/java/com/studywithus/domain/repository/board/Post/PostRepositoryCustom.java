package com.studywithus.domain.repository.board.Post;

import com.querydsl.core.Tuple;
import com.studywithus.domain.entity.board.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface PostRepositoryCustom {
    // 구현할 메서드 명세 작성
    List<Tuple> getPost();
    Object getPostByPostId(@Param("post_id") Long post_id);
    Page<Object[]> getPostsByCategory(@Param("category") String category, Pageable pageable);
    void deleteByPostId(@Param("post_id") Long Post_id);
}
