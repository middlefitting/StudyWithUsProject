package com.studywithus.domain.study;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long study_id;

    @Column(length = 50)
    private String study_name;

    private String study_manager;

    @Column(columnDefinition = "CHAR(1) default '1'")
    private String is_public;

    private String study_explanation;
}