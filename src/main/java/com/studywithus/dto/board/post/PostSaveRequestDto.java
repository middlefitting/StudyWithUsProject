package com.studywithus.dto.board.post;

import com.studywithus.domain.board.Category;
import com.studywithus.domain.board.Post;
import com.studywithus.domain.member.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private Member mem_id;
    private Category category;
    private String title;
    private String content;
    private String file_dir;
    private Integer views;

    @Builder
    public PostSaveRequestDto(Member mem_id, Category category, String title, String content, String file_dir, Integer views) {
        this.mem_id = mem_id;
        this.category = category;
        this.title = title;
        this.content = content;
        this.file_dir = file_dir;
        this.views = views;
    }

    public Post toEntity() {
        return Post.builder()
                .mem_id(mem_id)
                .category(category)
                .title(title)
                .content(content)
                .views(0)
                .build();
    }
}
