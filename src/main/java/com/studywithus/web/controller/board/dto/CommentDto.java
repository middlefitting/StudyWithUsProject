package com.studywithus.web.controller.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long comment_id;
    private Long writer_id;
    private String writer_nickname;
    private Long post_id;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
