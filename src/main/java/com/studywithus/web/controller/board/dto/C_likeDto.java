package com.studywithus.web.controller.board.dto;

import java.time.LocalDateTime;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class C_likeDto {
    private Long like_id;
    private Long comment_id;
    private Long writer_id;
    private String writer_nickname;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
