package com.studywithus.domain.service.board;

import com.studywithus.web.controller.board.dto.PageRequestDTO;
import com.studywithus.web.controller.board.dto.PageResultDTO;
import com.studywithus.web.controller.board.dto.PostDto;
import com.studywithus.domain.entity.board.Post;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.repository.board.Post.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class PostServiceImpl implements PostService{

    private final PostRepository repository;

    @Override
    public Long register(PostDto dto) {
        dto.setViews(0); //default 0
        Post post = dtoToEntity(dto);
        repository.save(post);

        return post.getPost_id();
    }

    @Override
    public PageResultDTO<PostDto, Object[]> getList(String category, PageRequestDTO pageRequestDTO) {
        Function<Object[], PostDto> fn = (en -> entityToDto((Post)en[0],(Member) en[1]));

        Page<Object[]> result = repository.getPostsByCategory(
                category,
                pageRequestDTO.getPageable(Sort.by("regDate").descending())
        );
        return new PageResultDTO<>(result, fn);
    }
}
