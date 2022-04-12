package com.studywithus.domain.service.study.study;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.study.MemberStudy;
import com.studywithus.domain.entity.study.Study;
import com.studywithus.domain.repository.member.MemberRepository;
import com.studywithus.domain.repository.study.memberstudy.MemberStudyRepository;
import com.studywithus.domain.repository.study.study.StudyRepository;
import com.studywithus.domain.repository.study.study.dto.StudyDto;
import com.studywithus.domain.service.study.study.dto.CreateStudyDto;
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

    public Page<StudyDto> selectStudyPage(Pageable pageable){
        return studyRepository.searchStudyPage(pageable);
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
            return studyRepository.save(study).getId();
        }
        return 0L;
    }

    public Long joinDropStudy(Long memberId, Long StudyId){
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Study> study = studyRepository.findById(StudyId);

        if(member.orElseGet(Member::new).getId()!=null && study.orElseGet(Study::new).getId()!=null){
            Optional<MemberStudy> byMemberAndStudy = memberStudyRepository.findByMemberAndStudy(member.orElseGet(Member::new), study.orElseGet(Study::new));

            if(byMemberAndStudy.orElseGet(MemberStudy::new).getId()==null){
                MemberStudy memberStudy = MemberStudy.builder()
                        .study(study.get())
                        .member(member.get())
                        .build();

                study.get().studyMemberCountPlus();
                studyRepository.save(study.get());
                return memberStudyRepository.save(memberStudy).getId();
            }

            else {
                memberStudyRepository.delete(byMemberAndStudy.get());
                study.get().studyMemberCountMinus();
                studyRepository.save(study.get());
                return 0L;
            }
        }
        throw new RuntimeException();
    }



}
