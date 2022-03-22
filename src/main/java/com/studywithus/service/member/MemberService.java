package com.studywithus.service.member;

import com.studywithus.domain.member.Member;
import com.studywithus.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(Member member){
        memberRepository.save(member);
        return member.getId();
    }

//    public void update(Long id, Member updateMember){
//        Member member = memberRepository.findById(id);
//        member.Member(updateMember);
//    }


}
