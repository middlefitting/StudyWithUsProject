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
public class C_like extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long like_id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment_id;

    @ManyToOne
    @JoinColumn(name = "mem_id")
    private Member mem_id;
}
