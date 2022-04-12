package com.studywithus.domain.repository.search;

import com.studywithus.domain.entity.board.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchRepositoryCustom {
//    Post search();
    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
