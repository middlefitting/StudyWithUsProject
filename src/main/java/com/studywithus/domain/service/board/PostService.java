package com.studywithus.domain.service.board;

import com.studywithus.web.controller.board.dto.PageRequestDTO;
import com.studywithus.web.controller.board.dto.PageResultDTO;
import com.studywithus.web.controller.board.dto.PostDto;
import com.studywithus.domain.entity.board.Post;
import com.studywithus.domain.entity.member.Member;
import org.springframework.data.repository.query.Param;

public interface PostService {
    Long register(PostDto dto);
    PostDto get(Long post_id);

    PageResultDTO<PostDto, Object[]> getList(@Param("category") String category, PageRequestDTO pageRequestDTO);

    default Post dtoToEntity(PostDto dto) {
        Member member = Member.builder().id(dto.getWriter_id()).build();
        Post post = Post.builder()
                .post_id(dto.getPost_id())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .category(dto.getCategory())
                .views(dto.getViews())
                .build();
        return post;
    }

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
