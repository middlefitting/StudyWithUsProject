package com.studywithus.domain.entity.board;

import com.studywithus.domain.entity.BaseEntity;
import com.studywithus.domain.enums.Category;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_id", referencedColumnName = "mem_id")
    private Member mem_id;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(length = 50)
    private String title;

    private String content;

    private String file_dir;

    @Column(columnDefinition = "varchar2(4000) default '0'")
    private Integer views;
}
