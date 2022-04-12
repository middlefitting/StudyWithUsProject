package com.studywithus.domain.service.board;

import com.studywithus.domain.repository.member.MemberRepository;
import com.studywithus.web.controller.board.dto.PageRequestDTO;
import com.studywithus.web.controller.board.dto.PageResultDTO;
import com.studywithus.web.controller.board.dto.PostDto;
import com.studywithus.domain.entity.board.Post;
import com.studywithus.domain.entity.member.Member;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface PostService {
    Long register(PostDto postDto);
    ArrayList<PostDto> get(@Param("post_id") Long post_id);

    PageResultDTO<PostDto, Object[]> getList(PageRequestDTO pageRequestDTO);

    Long remove(Long post_id);

    Long modify(PostDto postDto);

    Post dtoToEntity(PostDto dto);

/*    Post dtoToEntity(PostDto dto);
    PostDto entityToDto(Post post, Member member);*/

    default PostDto entityToDto(Post post, Member member) {
        PostDto postDto = PostDto.builder()
                .post_id(post.getPost_id())
                .title(post.getTitle())
                .content(post.getContent())
                .writer_id(member.getId())
                .writer_nickname(member.getNickname())
                .category(post.getCategory())
                .views(post.getViews())
                .modDate(post.getModDate())
                .regDate(post.getRegDate())
                .build();
        return postDto;
    }




}
