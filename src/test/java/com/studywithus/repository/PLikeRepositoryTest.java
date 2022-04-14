//package com.studywithus.repository;
//
//import com.querydsl.core.Tuple;
//import com.studywithus.domain.entity.board.Category;
//import com.studywithus.domain.entity.board.P_like;
//import com.studywithus.domain.entity.board.Post;
//import com.studywithus.domain.entity.member.Member;
//import com.studywithus.domain.repository.board.P_like.P_likeRepository;
//import com.studywithus.domain.repository.board.Post.PostRepository;
//import com.studywithus.domain.repository.member.MemberRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.stream.IntStream;
//
//@SpringBootTest
//@WebAppConfiguration
//public class PLikeRepositoryTest {
//    @Autowired
//    private PostRepository postRepository;
//    @Autowired
//    private MemberRepository memberRepository;
//    @Autowired
//    private P_likeRepository p_likeRepository;
//
//    @Test
//    @Transactional
//    public void testGetLike() {
//        IntStream.rangeClosed(1, 30).forEach(i -> {
//            Member member = Member.builder()
//                    .email("user" + i + "@aaa.com")
//                    .nickname("user" + i)
//                    .password("1234")
//                    .bornDate("2000.01.01")
//                    .build();
////            memberRepository.save(member);
//
//            Post post = Post.builder()
//                    .writer(member)
//                    .title(i + " title")
//                    .category(Category.notice)
//                    .content(i + " content")
//                    .build();
//
//            long bno = (long) (Math.random() * 20) + 1;
//            P_like p_like = P_like.builder()
//                    .mem_id(member)
//                    .post_id(bno)
//                    .build();
//            p_likeRepository.save(p_like);
//        });
//        List<Tuple> arr = p_likeRepository.getP_like(2L);
//        for (Tuple tmp : arr) {
//            System.out.println(tmp);
//        }
//        System.out.println(arr.size());
//    }
//}
