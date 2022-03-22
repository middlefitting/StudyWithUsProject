package com.studywithus.domain.study;

import com.studywithus.domain.BaseEntity;
import com.studywithus.domain.member.Member;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemStudy extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memStudy_id; // 아이디(pk)

    @JoinColumn(name = "study_id")
    @ManyToOne
    private Study study_id;

    @JoinColumn(name = "mem_id")
    @ManyToOne
    private Member mem_id;
}
