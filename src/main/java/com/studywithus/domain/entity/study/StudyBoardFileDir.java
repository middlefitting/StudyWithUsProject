package com.studywithus.domain.entity.study;

import com.studywithus.domain.entity.BaseConstructorEntity;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="study_board_file_dir")
@NoArgsConstructor
public class StudyBoardFileDir extends BaseConstructorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "study_board_file_dir_id")
    private Long id;

    private String fileDir;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="study_board_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudyBoard studyBoard;
}
