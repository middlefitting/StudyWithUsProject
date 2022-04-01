package com.studywithus.service.board;

import com.studywithus.controller.board.dto.PostDto;
import com.studywithus.domain.board.Post;
import com.studywithus.repository.board.Post.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PostServiceImpl implements PostService{

    private final PostRepository repository;

    @Override
    public Long register(PostDto dto) {
        log.info(dto);
        Post post = dtoToEntity(dto);
        repository.save(post);

        return post.getPost_id();
    }
}
