package com.studywithus.domain.service.study.studyboardview;

import com.studywithus.domain.entity.study.StudyBoardView;
import com.studywithus.domain.repository.study.studyboardview.StudyBoardViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyBoardViewServiceImpl implements StudyBoardViewService{
    private final StudyBoardViewRepository studyBoardViewRepository;

    public List<StudyBoardView> selectStudyBoardViews(Long studyBoardId){
        return studyBoardViewRepository.findStudyBoardViews(studyBoardId);
    }

}
