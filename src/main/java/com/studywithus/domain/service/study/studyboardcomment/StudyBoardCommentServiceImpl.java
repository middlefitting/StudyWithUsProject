package com.studywithus.domain.service.study.studyboardcomment;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.study.Study;
import com.studywithus.domain.entity.study.StudyBoard;
import com.studywithus.domain.entity.study.StudyBoardComment;
import com.studywithus.domain.repository.member.MemberRepository;
import com.studywithus.domain.repository.study.memberstudy.MemberStudyRepository;
import com.studywithus.domain.repository.study.studyboard.StudyBoardRepository;
import com.studywithus.domain.repository.study.studyboard.dto.StudyBoardSingleDto;
import com.studywithus.domain.repository.study.studyboardcomment.StudyBoardCommentRepository;
import com.studywithus.domain.repository.study.studyboardcomment.dto.StudyBoardCommentDto;
import com.studywithus.domain.service.study.studyboard.dto.UpdateStudyBoardDto;
import com.studywithus.domain.service.study.studyboardcomment.dto.CreateStudyBoardCommentDto;
import com.studywithus.domain.service.study.studyboardcomment.dto.UpdateStudyBoardCommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyBoardCommentServiceImpl implements StudyBoardCommentService {
    private final StudyBoardCommentRepository studyBoardCommentRepository;
    private final StudyBoardRepository studyBoardRepository;
    private final MemberRepository memberRepository;
    private final MemberStudyRepository memberStudyRepository;

    public Page<StudyBoardCommentDto> selectStudyBoardComments(Pageable pageable, Long studyBoardId) {
        return studyBoardCommentRepository.searchStudyBoardComment(pageable, studyBoardId);
    }

    public Long createStudyBoardComments(CreateStudyBoardCommentDto requestDto) {
        Optional<Long> isMember = memberStudyRepository.findByMemberIdAndStudyId(requestDto.getMemberId(), requestDto.getStudyId());

        if (!isMember.orElseGet(() -> 0L).equals(0L)) {
            Optional<Member> member = memberRepository.findById(requestDto.getMemberId());
            Optional<StudyBoard> studyBoard = studyBoardRepository.findById(requestDto.getStudyBoardId());
            studyBoard.get().studyBoardCommentCountPlus();
            studyBoardRepository.save(studyBoard.get());

            StudyBoardComment studyBoardComment = StudyBoardComment.builder()
                    .member(member.orElseGet(Member::new))
                    .studyBoard(studyBoard.orElseGet(StudyBoard::new))
                    .content(requestDto.getContent())
                    .studyBoardCommentRecommendCount(0L)
                    .studyBoardCommentReportCount(0L)
                    .build();
            return studyBoardCommentRepository.save(studyBoardComment).getId();
        }
        return 0L;
    }


    public Optional<StudyBoardComment> selectStudyBoardCommentSingle(Long memberId, Long studyBoardCommentId){
        return studyBoardCommentRepository.searchStudyBoardCommentSingle(memberId, studyBoardCommentId);
    }


    public Optional<StudyBoardComment> updateStudyBoardComment(UpdateStudyBoardCommentDto requestDto){
        Optional<StudyBoardComment> studyBoardComment = studyBoardCommentRepository.searchStudyBoardCommentSingle(requestDto.getMemberId(), requestDto.getStudyBoardCommentId());
        if(studyBoardComment.orElseGet(StudyBoardComment::new).getMember().getId().equals(requestDto.getMemberId())){
            studyBoardComment.get().updateComment(requestDto.getContent());
            studyBoardCommentRepository.save(studyBoardComment.get()).getId();
            return studyBoardComment;
        }
        throw new RuntimeException();
    }


    public Long deleteStudyBoardComment(Long memberId, Long studyBoardCommentId){
        Optional<StudyBoardComment> studyBoardComment = studyBoardCommentRepository.findById(studyBoardCommentId);
        if(studyBoardComment.orElseGet(StudyBoardComment::new).getId()!=null){
            if (studyBoardComment.orElseGet(StudyBoardComment::new).getMember().getId().equals(memberId)){
                Optional<StudyBoard> studyBoard = studyBoardRepository.findById(studyBoardComment.get().getStudyBoard().getId());
                studyBoard.get().studyBoardCommentCountMinus();
                studyBoardRepository.save(studyBoard.get());

                studyBoardCommentRepository.delete(studyBoardComment.get());
                return -1L;
            }
        }
        return 0L;
    }







}
