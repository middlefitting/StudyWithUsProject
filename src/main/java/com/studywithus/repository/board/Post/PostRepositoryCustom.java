package com.studywithus.repository.board.Post;

import com.studywithus.domain.board.Post;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepositoryCustom {
    // 구현할 메서드 명세 작성
    Object getPost();
    Object getPostByPostId(@Param("post_id") Long post_id);
    Object getPostByCategory(@Param("category") String category);
}
