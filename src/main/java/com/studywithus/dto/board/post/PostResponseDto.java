package com.studywithus.dto.board.post;

import com.studywithus.domain.enums.Category;
import com.studywithus.domain.entity.board.Post;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private final Long post_id;
    private final String writer;
    private final Category category;
    private final String title;
    private final String content;
    private final String file_dir;
    private final Integer views;
    private final LocalDateTime regDate;
    private final LocalDateTime modDate;

    public PostResponseDto(Post post) {
        this.post_id = post.getPost_id();
        this.writer = post.getMem_id().getNickname();
        this.category = post.getCategory();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.file_dir = post.getFile_dir();
        this.views = post.getViews();
        this.regDate = post.getRegDate();
        this.modDate = post.getModDate();
    }
}
