package com.studywithus.service.board;

import com.studywithus.domain.entity.board.Post;
import com.studywithus.dto.board.post.PostSaveRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    // C
    Long createPost(PostSaveRequestDto postSaveRequestDto);

    // R - All
    List<Post> getAllPost();

    Page<Post> findPostList(Pageable pageable);

    Post findPostById(Long post_id);
}
