package com.studywithus.domain.service.study.studyboardcommentreport;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.study.*;
import com.studywithus.domain.repository.member.MemberRepository;
import com.studywithus.domain.repository.study.studyboardcomment.StudyBoardCommentRepository;
import com.studywithus.domain.repository.study.studyboardcommentreport.StudyBoardCommentReportRepository;
import com.studywithus.domain.service.study.studyboardcommentreport.dto.CreateStudyBoardCommentReportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyBoardCommentReportServiceImpl implements StudyBoardCommentReportService{
    private final StudyBoardCommentReportRepository studyBoardCommentReportRepository;
    private final MemberRepository memberRepository;
    private final StudyBoardCommentRepository studyBoardCommentRepository;

    public Long selectStudyBoardCommentReport(Long memberId, Long studyBoardCommentId){
        Optional<StudyBoardCommentReport> studyBoardCommentReportOptional = studyBoardCommentReportRepository.findByMemberIdAndStudyBoardCommentId(memberId, studyBoardCommentId);

        if(studyBoardCommentReportOptional.orElseGet(StudyBoardCommentReport::new).getId() == null){
            return 0L;
        }
        return 1L;
    }


    public Long joinDropStudyBoardCommentReport(CreateStudyBoardCommentReportDto requestDto){
        Optional<StudyBoardCommentReport> studyBoardCommentReportOptional = studyBoardCommentReportRepository.findByMemberIdAndStudyBoardCommentId(requestDto.getMemberId(), requestDto.getStudyBoardCommentId());
        if(studyBoardCommentReportOptional.orElseGet(StudyBoardCommentReport::new).getId() == null){
            Optional<StudyBoardComment> studyBoardComment = studyBoardCommentRepository.findById(requestDto.getStudyBoardCommentId());
            Optional<Member> member = memberRepository.findById(requestDto.getMemberId());
            studyBoardComment.get().studyBoardCommentReportCountPlus();
            studyBoardCommentRepository.save(studyBoardComment.get());

            StudyBoardCommentReport studyBoardCommentReport = StudyBoardCommentReport.builder()
                    .member(member.get())
                    .studyBoardComment(studyBoardComment.get())
                    .studyBoardCommentReportCategory(requestDto.getStudyBoardCommentReportCategory())
                    .build();

            studyBoardCommentReportRepository.save(studyBoardCommentReport);
            return -1L;
        }
        return 0L;
    }
}
