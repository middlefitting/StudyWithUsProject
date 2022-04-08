package com.studywithus.domain.board;

import com.studywithus.domain.BaseEntity;
import com.studywithus.domain.entity.member.Member;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long post_id;

    @ManyToOne
    @JoinColumn(name = "mem_id")
    private Member mem_id;

    private Category category;

    @Column(length = 50)
    private String title;

    private String content;

    private String file_dir;

    @Column(columnDefinition = "varchar2(4000) default '0'")
    private Integer views;
}
