package com.studywithus.domain.service.study.memberstudy;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.entity.study.MemberStudy;
import com.studywithus.domain.entity.study.Study;
import com.studywithus.domain.repository.member.MemberRepository;
import com.studywithus.domain.repository.study.memberstudy.MemberStudyRepository;
import com.studywithus.domain.repository.study.study.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberStudyServiceImpl implements MemberStudyService{
    private final StudyRepository studyRepository;
    private final MemberRepository memberRepository;
    private final MemberStudyRepository memberStudyRepository;

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
                return -1L;
            }
        }
        return 0L;
    }


    public Long selectStudyMember(Long memberId, Long StudyId){
        Optional<Long> memberStudy = memberStudyRepository.findByMemberIdAndStudyId(memberId, StudyId);
        if(memberStudy.orElseGet(() -> 0L).equals(0L)){
            return 0L;
        }
        return memberStudy.get();
    }

}
