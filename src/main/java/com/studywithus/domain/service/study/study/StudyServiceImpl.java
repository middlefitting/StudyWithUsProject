package com.studywithus.domain.service.study.study;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.study.MemberStudy;
import com.studywithus.domain.entity.study.Study;
import com.studywithus.domain.repository.member.MemberRepository;

import com.studywithus.domain.repository.study.memberstudy.MemberStudyRepository;
import com.studywithus.domain.repository.study.study.StudyRepository;
import com.studywithus.domain.repository.study.study.dto.StudyDto;
import com.studywithus.domain.repository.study.study.dto.StudyPageSearchCondition;
import com.studywithus.domain.service.member.MemberService;
import com.studywithus.domain.service.study.study.dto.CreateStudyDto;
import com.studywithus.domain.service.study.study.dto.UpdateStudyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService{

    private final StudyRepository studyRepository;
    private final MemberRepository memberRepository;
    private final MemberStudyRepository memberStudyRepository;

    public Page<StudyDto> selectStudyPage(Pageable pageable, StudyPageSearchCondition condition){
        return studyRepository.searchStudyPage(pageable, condition);
    }

    public Long createStudy(CreateStudyDto requestDto){
        Optional<Member> member = memberRepository.findById(requestDto.getMemberId());
        if(member.get().getId()!=null){
            if(!studyRepository.searchStudyByMember(member.get().getId()).orElse(0L).equals(0L)){
                throw new IllegalStateException("스터디는 한 아이디에 하나만 생성 가능합니다");
            }

            Study study = Study.builder()
                    .studyName(requestDto.getStudyName())
                    .studyExplanation(requestDto.getStudyExplanation())
                    .member(member.get())
                    .studyMemberCount(1L)
                    .build();

            Long result = studyRepository.save(study).getId();

            MemberStudy memberStudy = MemberStudy.builder()
                    .member(member.get())
                    .study(study)
                    .build();

            memberStudyRepository.save(memberStudy);

//            return studyRepository.save(study).getId();
            return result;


        }
        return 0L;
    }


//    public Optional<Study> getStudy(Long studyId){
//        Optional<Study> study = studyRepository.findById(studyId);
//        if(study.orElseGet(Study::new).getId().equals(studyId)){
//            return study;
//        }
//        throw new RuntimeException();
//    }


    public Optional<Study> getStudy(Long studyId){
        Optional<Study> study = studyRepository.searchStudyByIdFetch(studyId);
        if(study.orElseGet(Study::new).getId().equals(studyId)){
            return study;
        }
        throw new RuntimeException();
    }


    public Long updateStudy(UpdateStudyDto requestDto){
        Optional<Study> study = studyRepository.findById(requestDto.getStudyId());
        if(study.orElseGet(Study::new).getMember().getId().equals(requestDto.getMemberId())){
            study.get().updateStudyEntity(requestDto.getStudyName(), requestDto.getStudyExplanation());
            return studyRepository.save(study.get()).getId();
        }
        throw new RuntimeException();
    }


    public void deleteStudy(Long studyId, Long memberId){
        Optional<Study> study = studyRepository.findById(studyId);
        if(study.orElseGet(Study::new).getMember().getId().equals(memberId)){
            studyRepository.delete(study.get());
            return;
        }
        throw new RuntimeException();
    }


    //updateStudy(requestDto, verifyId)



}
