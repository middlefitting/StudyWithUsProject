package com.studywithus.domain.service.study.studyboardrecommend;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.study.StudyBoard;
import com.studywithus.domain.entity.study.StudyBoardCommentRecommend;
import com.studywithus.domain.entity.study.StudyBoardRecommend;
import com.studywithus.domain.entity.study.StudyBoardView;
import com.studywithus.domain.repository.member.MemberRepository;
import com.studywithus.domain.repository.study.studyboard.StudyBoardRepository;
import com.studywithus.domain.repository.study.studyboardrecommend.StudyBoardRecommendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyBoardRecommendServiceImpl implements StudyBoardRecommendService{

    private final StudyBoardRecommendRepository studyBoardRecommendRepository;
    private final MemberRepository memberRepository;
    private final StudyBoardRepository studyBoardRepository;


    public Long selectStudyBoardRecommend(Long memberId, Long studyBoardId){
        Optional<StudyBoardRecommend> studyBoardRecommendOptional = studyBoardRecommendRepository.findByMemberIdAndStudyBoardId(memberId, studyBoardId);

        if(studyBoardRecommendOptional.orElseGet(StudyBoardRecommend::new).getId() == null){
            return 0L;
        }
        return 1L;
    }


    public Long joinDropStudyBoardRecommend(Long memberId, Long studyBoardId){
        Optional<StudyBoardRecommend> studyBoardRecommendOptional = studyBoardRecommendRepository.findByMemberIdAndStudyBoardId(memberId, studyBoardId);
        if(studyBoardRecommendOptional.orElseGet(StudyBoardRecommend::new).getId() == null){
            Optional<StudyBoard> studyBoard = studyBoardRepository.findById(studyBoardId);
            Optional<Member> member = memberRepository.findById(memberId);
            studyBoard.get().studyBoardRecommendCountPlus();
            studyBoardRepository.save(studyBoard.get());

            StudyBoardRecommend studyBoardRecommend = StudyBoardRecommend.builder()
                    .member(member.get())
                    .studyBoard(studyBoard.get())
                    .build();

            studyBoardRecommendRepository.save(studyBoardRecommend);
            return -1L;
        }

        Optional<StudyBoard> studyBoard = studyBoardRepository.findById(studyBoardId);
        studyBoard.get().studyBoardRecommendCountMinus();
        studyBoardRepository.save(studyBoard.get());
        studyBoardRecommendRepository.delete(studyBoardRecommendOptional.get());
        return 0L;
    }
}
