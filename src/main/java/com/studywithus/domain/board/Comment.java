package com.studywithus.domain.board;

import com.studywithus.domain.BaseEntity;
import com.studywithus.domain.member.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comment_id; // 댓글 아이디(pk)

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post_id;// 댓글 쓴 게시글 아이디(fk)

    @ManyToOne
    @JoinColumn(name = "mem_id")
    private Member mem_id;// 댓글 쓴 멤버 아이디(fk)

    private String content;// 댓글 내용
}
