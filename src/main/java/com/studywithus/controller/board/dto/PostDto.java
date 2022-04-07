package com.studywithus.controller.board.dto;

import com.studywithus.domain.board.Category;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long post_id;
    private String title;
    private String content;
    private Long writer_id;
    private String writer_nickname;
    private Category category;
    private Integer views;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
