package com.studywithus.domain.service.study.studyboardreport;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.study.StudyBoard;
import com.studywithus.domain.entity.study.StudyBoardReport;
import com.studywithus.domain.repository.member.MemberRepository;
import com.studywithus.domain.repository.study.studyboard.StudyBoardRepository;
import com.studywithus.domain.repository.study.studyboardreport.StudyBoardReportRepository;
import com.studywithus.domain.service.study.studyboardreport.dto.CreateStudyBoardReportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyBoardReportServiceImpl implements StudyBoardReportService{
    private final StudyBoardReportRepository studyBoardReportRepository;
    private final MemberRepository memberRepository;
    private final StudyBoardRepository studyBoardRepository;

    public Long selectStudyBoardReport(Long memberId, Long studyBoardId){
        Optional<StudyBoardReport> studyBoardReportOptional = studyBoardReportRepository.findByMemberIdAndStudyBoardId(memberId, studyBoardId);

        if(studyBoardReportOptional.orElseGet(StudyBoardReport::new).getId() == null){
            return 0L;
        }
        return 1L;
    }


    public Long joinDropStudyBoardReport(CreateStudyBoardReportDto requestDto){
        Optional<StudyBoardReport> studyBoardReportOptional = studyBoardReportRepository.findByMemberIdAndStudyBoardId(requestDto.getMemberId(), requestDto.getStudyBoardId());
        if(studyBoardReportOptional.orElseGet(StudyBoardReport::new).getId() == null){
            Optional<StudyBoard> studyBoard = studyBoardRepository.findById(requestDto.getStudyBoardId());
            Optional<Member> member = memberRepository.findById(requestDto.getMemberId());
            studyBoard.get().studyBoardReportCountPlus();
            studyBoardRepository.save(studyBoard.get());

            StudyBoardReport studyBoardReport = StudyBoardReport.builder()
                    .member(member.get())
                    .studyBoard(studyBoard.get())
                    .studyBoardReportCategory(requestDto.getStudyBoardReportCategory())
                    .build();

            studyBoardReportRepository.save(studyBoardReport);
            return -1L;
        }
        return 0L;
    }
}
