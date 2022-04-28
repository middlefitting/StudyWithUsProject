package com.studywithus.domain.service.study.studyboardcommentrecommend;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.study.StudyBoardComment;
import com.studywithus.domain.entity.study.StudyBoardCommentRecommend;
import com.studywithus.domain.entity.study.StudyBoardRecommend;
import com.studywithus.domain.repository.member.MemberRepository;
import com.studywithus.domain.repository.study.studyboardcomment.StudyBoardCommentRepository;
import com.studywithus.domain.repository.study.studyboardcommentrecommend.StudyBoardCommentRecommendRepository;
import com.studywithus.domain.repository.study.studyboardrecommend.StudyBoardRecommendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyBoardCommentRecommendServiceImpl implements StudyBoardCommentRecommendService{

    private final StudyBoardCommentRecommendRepository studyBoardCommentRecommendRepository;
    private final MemberRepository memberRepository;
    private final StudyBoardCommentRepository studyBoardCommentRepository;


    public Long selectStudyBoardCommentRecommend(Long memberId, Long studyBoardCommentId){
        Optional<StudyBoardCommentRecommend> studyBoardCommentRecommendOptional = studyBoardCommentRecommendRepository.findByMemberIdAndStudyBoardCommentId(memberId, studyBoardCommentId);

        if(studyBoardCommentRecommendOptional.orElseGet(StudyBoardCommentRecommend::new).getId() == null){
            return 0L;
        }
        return 1L;
    }


    public Long joinDropStudyBoardCommentRecommend(Long memberId, Long studyBoardCommentId){

        Optional<StudyBoardCommentRecommend> studyBoardCommentRecommendOptional = studyBoardCommentRecommendRepository.findByMemberIdAndStudyBoardCommentId(memberId, studyBoardCommentId);

        if(studyBoardCommentRecommendOptional.orElseGet(StudyBoardCommentRecommend::new).getId() == null){
            Optional<StudyBoardComment> studyBoardComment = studyBoardCommentRepository.findById(studyBoardCommentId);
            Optional<Member> member = memberRepository.findById(memberId);
            studyBoardComment.get().studyBoardCommentRecommendCountPlus();
            studyBoardCommentRepository.save(studyBoardComment.get());

            StudyBoardCommentRecommend studyBoardCommentRecommend = StudyBoardCommentRecommend.builder()
                    .member(member.get())
                    .studyBoardComment(studyBoardComment.get())
                    .build();

            studyBoardCommentRecommendRepository.save(studyBoardCommentRecommend);
            return -1L;
        }

        Optional<StudyBoardComment> studyBoardComment = studyBoardCommentRepository.findById(studyBoardCommentId);
        studyBoardComment.get().studyBoardCommentRecommendCountMinus();
        studyBoardCommentRepository.save(studyBoardComment.get());
        studyBoardCommentRecommendRepository.delete(studyBoardCommentRecommendOptional.get());
        return 0L;
    }
}
