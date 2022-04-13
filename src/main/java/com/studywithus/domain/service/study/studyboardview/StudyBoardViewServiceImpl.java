package com.studywithus.domain.service.study.studyboardview;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.study.StudyBoard;
import com.studywithus.domain.entity.study.StudyBoardView;
import com.studywithus.domain.repository.member.MemberRepository;
import com.studywithus.domain.repository.study.studyboard.StudyBoardRepository;
import com.studywithus.domain.repository.study.studyboardview.StudyBoardViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyBoardViewServiceImpl implements StudyBoardViewService{
    private final StudyBoardViewRepository studyBoardViewRepository;
    private final MemberRepository memberRepository;
    private final StudyBoardRepository studyBoardRepository;

    public void appendStudyBoardViews(Long memberId, Long studyBoardId){
        Optional<StudyBoardView> StudyBoardViewOptional = studyBoardViewRepository.findByMemberIdAndStudyBoardId(memberId, studyBoardId);
        if(StudyBoardViewOptional.orElseGet(StudyBoardView::new).getId() == null){
            Optional<StudyBoard> studyBoard = studyBoardRepository.findById(studyBoardId);
            Optional<Member> member = memberRepository.findById(memberId);
            studyBoard.get().studyBoardViewCountPlus();
            studyBoardRepository.save(studyBoard.get());

            StudyBoardView studyBoardView = StudyBoardView.builder()
                    .member(member.get())
                    .studyBoard(studyBoard.get())
                    .build();

            studyBoardViewRepository.save(studyBoardView);
        }
    }

}
