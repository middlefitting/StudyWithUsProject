package com.studywithus.domain.repository.board.Post;

import com.studywithus.domain.entity.board.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
}
