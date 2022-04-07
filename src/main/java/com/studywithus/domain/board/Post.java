package com.studywithus.domain.board;

import com.studywithus.domain.BaseEntity;
import com.studywithus.domain.member.Member;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "writer")
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long post_id;

    @ManyToOne(fetch = FetchType.LAZY) // Test 할 때 @Transactional 추가해줘야 함
    @JoinColumn(name = "member_id")
    private Member writer;

    private Category category;

    @Column(length = 50)
    private String title;

    private String content;

    private String file_dir;

    private Integer views;
}
