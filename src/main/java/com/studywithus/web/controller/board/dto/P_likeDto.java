package com.studywithus.web.controller.board.dto;

import com.studywithus.domain.entity.member.Member;
import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class P_likeDto {
    private Long like_id;
    private Long member_id;
    private Long post_id;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
