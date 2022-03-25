package com.studywithus.service.member;

import com.studywithus.domain.member.Member;
import com.studywithus.dto.member.CreateMemberRequestDto;
import com.studywithus.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(CreateMemberRequestDto requestDto){
        Member member = new Member(requestDto.getEmail(), requestDto.getNickname(), requestDto.getPassword(), requestDto.getBornDate());
        memberRepository.save(member);
        return member.getId();
    }

    public void update(Long id, Member updateMember){
        Optional<Member> optionalMember = memberRepository.findById(id);
        optionalMember.get().UpdateMember(updateMember);
    }


}
