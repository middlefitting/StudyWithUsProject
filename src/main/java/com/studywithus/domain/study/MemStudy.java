package com.studywithus.domain.study;

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
public class MemStudy extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memStudy_id;

    @ManyToOne
    @JoinColumn(name = "study_id")
    private Study study_id;

    @ManyToOne
    @JoinColumn(name = "mem_id")
    private Member mem_id;
}
