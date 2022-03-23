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
@ToString
public class P_like extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long like_id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post_id;

    @ManyToOne
    @JoinColumn(name = "mem_id")
    private Member mem_id;
}
