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
public class C_like extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long like_id; // 아이디(pk)

    @JoinColumn(name = "comment_id")
    @ManyToOne
    private Comment comment_id;

    @JoinColumn(name = "mem_id")
    @ManyToOne
    private Member mem_id;
}
