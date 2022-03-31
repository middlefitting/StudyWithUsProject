package com.studywithus.repository.member;

import com.studywithus.domain.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입 Repository")
    public void testSave() throws Exception{
        //given
        Member member = CreateMemberEntity();
        //when
        Member savedMember = memberRepository.save(member);
        //then
        assertThat(member).isEqualTo(savedMember);
        assertThat(member.getId()).isEqualTo(savedMember.getId());
        assertThat(member.getEmail()).isEqualTo(savedMember.getEmail());
        assertThat(member.getNickname()).isEqualTo(savedMember.getNickname());
        assertThat(member.getPassword()).isEqualTo(savedMember.getPassword());
        assertThat(member.getBornDate()).isEqualTo(savedMember.getBornDate());
    }

    @Test
    @DisplayName("회원 전체 조회 Repository")
    public void TestFindAll() throws Exception{
        //given
        CreateMembersEntity();
        Member member = new Member("wjdtmdcjf199@naver.com",
                "middleFitting","@123Middle", "1996-06-25");
        Member member2 = new Member("min123@naver.com",
                "happy","@123min", "2000-02-22");
        List<Member> compareMembers = new ArrayList<>();
        compareMembers.add(member);
        compareMembers.add(member2);

        //when
        List<Member> members = memberRepository.findAll();

        //then
        assertThat(members.size()).isEqualTo(2);
        for(int i = 0; i < 2; i++){
            assertThat(members.get(i).getEmail()).isEqualTo(compareMembers.get(i).getEmail());
            assertThat(members.get(i).getNickname()).isEqualTo(compareMembers.get(i).getNickname());
            assertThat(members.get(i).getPassword()).isEqualTo(compareMembers.get(i).getPassword());
            assertThat(members.get(i).getBornDate()).isEqualTo(compareMembers.get(i).getBornDate());
        }
    }

    @Test
    @DisplayName("회원 단건 조회 Repository")
    public void TestFindById() throws Exception{
        //given
        CreateMembersEntity();
        Member member = new Member("wjdtmdcjf199@naver.com",
                "middleFitting","@123Middle", "1996-06-25");
        Member member2 = new Member("min123@naver.com",
                "happy","@123min", "2000-02-22");
        List<Member> compareMembers = new ArrayList<>();
        compareMembers.add(member);
        compareMembers.add(member2);

        //when
        Optional<Member> findMember = memberRepository.findById(1L);

        //then
        assertThat(findMember.get().getId()).isEqualTo(1L);
        assertThat(findMember.get().getEmail()).isEqualTo(member.getEmail());
        assertThat(findMember.get().getNickname()).isEqualTo(member.getNickname());
        assertThat(findMember.get().getPassword()).isEqualTo(member.getPassword());
        assertThat(findMember.get().getBornDate()).isEqualTo(member.getBornDate());

        //when
        Optional<Member> findMember2 = memberRepository.findById(3L);

        //then
        System.out.println("Optional = " + findMember.orElse(null));
        System.out.println("Optional = " + findMember2.orElse(null));

        System.out.println(Optional.of(findMember2.orElseGet(Member::new)).get().getId());
        assertThat(Optional.of(findMember2.orElseGet(Member::new)).get().getId()).isEqualTo(null);
    }


    private Member CreateMemberEntity(){
        Member member = new Member("wjdtmdcjf199@naver.com",
                "middleFitting","@123Middle", "1996-06-25");
        return  member;
    }

    private void CreateMembersEntity(){
        Member member = new Member("wjdtmdcjf199@naver.com",
                "middleFitting","@123Middle", "1996-06-25");
        Member member2 = new Member("min123@naver.com",
                "happy","@123min", "2000-02-22");
        memberRepository.save(member);
        memberRepository.save(member2);
    }
}