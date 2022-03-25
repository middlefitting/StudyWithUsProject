package com.studywithus.repository.member;

import com.studywithus.domain.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
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

    private Member CreateMemberEntity(){
        Member member = new Member("wjdtmdcjf199@naver.com",
                "middleFitting","@123Middle", "1996-0625");
        return  member;
    }
}