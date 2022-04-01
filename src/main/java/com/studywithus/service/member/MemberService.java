package com.studywithus.service.member;

import com.studywithus.domain.member.Member;
import com.studywithus.service.member.dto.CreateMemberRequestDto;
import com.studywithus.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(CreateMemberRequestDto requestDto){
//        Member member = new Member(requestDto.getEmail(), requestDto.getNickname(), requestDto.getPassword(), requestDto.getBornDate());
        Member member = Member.builder()
                .email(requestDto.getEmail())
                .nickname(requestDto.getNickname())
                .password(requestDto.getPassword())
                .bornDate(requestDto.getBornDate())
                .build();

        return memberRepository.save(member).getId();
    }

    public List<Member> selectAll() {
        return memberRepository.findAll();
    }

    public Optional<Member> selectById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return Optional.of(member.orElseGet(Member::new));
    }


    public void update(Long id, Member updateMember){
        Optional<Member> optionalMember = memberRepository.findById(id);
        return;
    }



}
