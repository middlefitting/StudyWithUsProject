package com.studywithus.domain.service.study.studyboard;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.study.Study;
import com.studywithus.domain.entity.study.StudyBoard;
import com.studywithus.domain.repository.member.MemberRepository;
import com.studywithus.domain.repository.study.memberstudy.MemberStudyRepository;
import com.studywithus.domain.repository.study.study.StudyRepository;
import com.studywithus.domain.repository.study.studyboard.StudyBoardRepository;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardDto;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardPageSearchCondition;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardSingleDto;
import com.studywithus.domain.service.study.studyboard.dto.CreateStudyBoardDto;
import com.studywithus.domain.service.study.studyboard.dto.UpdateStudyBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyBoardServiceImpl implements StudyBoardService{

    private final StudyBoardRepository studyBoardRepository;
    private final MemberRepository memberRepository;
    private final StudyRepository studyRepository;
    private final MemberStudyRepository memberStudyRepository;


    public Page<StudyBoardDto> selectStudyBoardPage(Pageable pageable, StudyBoardPageSearchCondition condition){
        return studyBoardRepository.searchStudyBoardPage(pageable, condition);
    }


    public Long createStudyBoard(CreateStudyBoardDto requestDto){

        Optional<Long> isMember = memberStudyRepository.findByMemberIdAndStudyId(requestDto.getMemberId(), requestDto.getStudyId());

        if(!isMember.orElseGet(() -> 0L).equals(0L)){
            Optional<Member> member = memberRepository.findById(requestDto.getMemberId());
            Optional<Study> study = studyRepository.findById(requestDto.getStudyId());

            StudyBoard studyBoard = StudyBoard.builder()
                    .title(requestDto.getTitle())
                    .content(requestDto.getContent())
                    .studyBoardCategory(requestDto.getStudyBoardCategory())
                    .member(member.orElseGet(Member::new))
                    .study(study.orElseGet(Study::new))
                    .studyBoardCommentCount(0L)
                    .studyBoardRecommendCount(0L)
                    .studyBoardReportCount(0L)
                    .studyBoardViewCount(0L)
                    .build();
            return studyBoardRepository.save(studyBoard).getId();
        }
        return 0L;
    }


    public Optional<StudyBoardSingleDto> selectStudyBoard(Long studyBoardId){
        return studyBoardRepository.searchStudyBoardSingle(studyBoardId);
    }


    public Long updateStudyBoard(UpdateStudyBoardDto requestDto){
        Optional<StudyBoard> studyBoard = studyBoardRepository.findById(requestDto.getStudyBoardId());
            if(studyBoard.orElseGet(StudyBoard::new).getMember().getId().equals(requestDto.getMemberId())){
                studyBoard.get().updateStudyBoard(requestDto.getTitle(), requestDto.getContent(), requestDto.getStudyBoardCategory());
                return studyBoardRepository.save(studyBoard.get()).getId();
            }
            return 0L;
        }


    public Long deleteStudyBoard(Long memberId, Long studyBoardId){
        Optional<StudyBoard> studyBoard = studyBoardRepository.searchStudyBoardByBoardAndMemberId(memberId, studyBoardId);
        System.out.println("================" + studyBoard.get().getId());
        if(studyBoard.orElseGet(StudyBoard::new).getId()!=null){
            if (studyBoard.orElseGet(StudyBoard::new).getMember().getId().equals(memberId)){
                studyBoardRepository.delete(studyBoard.get());
                return -1L;
                }
            }
            return 0L;
        }


}
