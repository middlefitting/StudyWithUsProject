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
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long post_id; // 게시글 아이디(pk)

    @ManyToOne
    private Member mem_id; // 작성자 아이디(fk)

    @Column(length = 50)
    private String title; // 게시글 제목

    private String content; // 게시글 내용

    private String file_dir; // 첨부 파일 경로

    private String category; // 카테고리

    @Column(columnDefinition = "varchar2(4000) default '0'")
    private Integer views; // 조회수
}
