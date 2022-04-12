package com.studywithus.domain.repository.search;

import com.studywithus.domain.entity.board.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<Post, Long>, SearchRepositoryCustom {
}
