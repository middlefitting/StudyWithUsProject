package com.studywithus.domain.repository.board.post;

import com.studywithus.domain.entity.board.Post;

import com.studywithus.domain.entity.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
    Post findByMember(Member member);

    Page<Post> findByMemberOrderByCreatedDateDesc(Member member, Pageable pageable);

    Page<Post> findAllByOrderByCreatedDateDesc(Pageable pageable);

    Optional<Post> findById(Long id);
}
