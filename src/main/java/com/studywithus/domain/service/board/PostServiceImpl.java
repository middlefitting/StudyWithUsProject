package com.studywithus.domain.service.board;

import com.querydsl.core.Tuple;
import com.studywithus.domain.repository.board.Comment.CommentRepository;
import com.studywithus.domain.repository.board.P_like.P_likeRepository;
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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class PostServiceImpl implements PostService{

    private final PostRepository repository;
    private final CommentRepository commentRepository;
    private final P_likeRepository p_likeRepository;

    @Override
    public Long register(PostDto dto) {
        dto.setViews(0); //default 0
        Post post = dtoToEntity(dto);
        repository.save(post);

        return post.getPost_id();
    }

    //캐스팅오류
    @Override
    public PostDto get(Long post_id) {
        Object result = repository.getPostByPostId(post_id);
        Object[] arr = (Object[]) result;
        return entityToDto((Post) arr[0], (Member) arr[1]);
    }

    @Override
    public PageResultDTO<PostDto, Object[]> getList(String category, PageRequestDTO pageRequestDTO) {
        Function<Object[], PostDto> fn = (en -> entityToDto((Post)en[0], (Member) en[1]));

        Page<Object[]> result = repository.getPostsByCategory(
                category,
                pageRequestDTO.getPageable(Sort.by("regDate").descending())
        );
        System.out.println("==================서비스 result============");
        System.out.println(result);
        return new PageResultDTO<>(result, fn);
    }

    @Transactional
    @Override
    public void remove(Long post_id) {
        //댓글삭제
//        commentRepository.deleteByPostId(post_id);
        //좋아요삭제
        //글삭제
        repository.deleteByPostId(post_id);
    }

    @Transactional
    @Override
    public void modify(PostDto postDto) {
        Post post = repository.getById(postDto.getPost_id());

        post.updatePost(postDto.getTitle(), postDto.getContent());
        repository.save(post);
    }


}
