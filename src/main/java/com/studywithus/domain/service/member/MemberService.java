package com.studywithus.domain.service.member;

import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.service.member.dto.CreateMemberRequestDto;
import com.studywithus.domain.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
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
                .roles("ROLE_USER")
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

    public Optional<Member> selectByEmail(String email) {
        Optional<Member> member = Optional.of(memberRepository.findByEmail(email).orElseGet(Member::new));
        return member;
    }

    public Optional<String> duplicateEmail(String email) {
        Optional<Member> member = Optional.of(memberRepository.findByEmail(email).orElseGet(Member::new));
        Optional<String> result = Optional.ofNullable(member.get().getEmail());
        return result;
    }

    public Optional<String> duplicateNickname(String nickname) {
        Optional<Member> member = Optional.of(memberRepository.findByNickname(nickname).orElseGet(Member::new));
        Optional<String> result = Optional.ofNullable(member.get().getNickname());
        return result;
    }

    public Member updateMember(CreateMemberRequestDto requestDto){
        Member member = Optional.of(memberRepository.findByEmail(requestDto.getEmail()).orElseGet(Member::new)).get();
        if(member.getEmail() != null){
            member.updateMember(requestDto.getNickname(), requestDto.getBornDate());
            memberRepository.save(member);
        }
        return member;
    }

    public String updateMemberPassword(CreateMemberRequestDto requestDto){
        Member member = Optional.of(memberRepository.findByEmail(requestDto.getEmail()).orElseGet(Member::new)).get();
        if(member.getEmail() != null){
            System.out.println(requestDto.getPassword());
            member.updatePassword(requestDto.getEmail(), requestDto.getPassword());
            memberRepository.save(member);
        }
        return "success";
    }

    public String deleteMember(String email) {
        memberRepository.deleteMemberByEmail(email);
        return "success";
    }





}
