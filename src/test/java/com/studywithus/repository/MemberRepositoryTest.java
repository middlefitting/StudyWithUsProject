//package com.studywithus.repository;
//
//
//import com.studywithus.domain.entity.member.Member;
//import com.studywithus.domain.repository.member.MemberRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.util.List;
//import java.util.stream.IntStream;
//
//@SpringBootTest
//@WebAppConfiguration
//public class MemberRepositoryTest {
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Test
//    public void testGetPost() {
//        IntStream.rangeClosed(1, 30).forEach(i -> {
//            Member member = Member.builder()
//                    .email("user" + i + "@aaa.com")
//                    .nickname("user" + i)
//                    .password("1234")
//                    .bornDate("2000.01.01")
//                    .build();
//            memberRepository.save(member);
//        });
//
////        List<Member> result = memberRepository.findByEmailPassword("user2@aaa.com", "1234");
////        System.out.println("---------------------------");
////        System.out.println(result);
//    }
//}
