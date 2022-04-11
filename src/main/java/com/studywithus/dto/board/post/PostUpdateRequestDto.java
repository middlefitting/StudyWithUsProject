package com.studywithus.dto.board.post;

import com.studywithus.domain.enums.Category;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostUpdateRequestDto {
    private Category category;
    private String title;
    private String content;
    private String file_dir;
    private Integer views;

    @Builder
    public PostUpdateRequestDto(Category category, String title, String content, String file_dir, Integer views) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.file_dir = file_dir;
        this.views = views;
    }
}
