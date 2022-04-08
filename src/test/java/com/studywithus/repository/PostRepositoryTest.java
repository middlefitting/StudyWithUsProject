//package com.studywithus.repository;
//
//import com.studywithus.domain.board.Category;
//import com.studywithus.domain.board.Post;
//import com.studywithus.domain.member.Member;
//import com.studywithus.repository.board.Post.PostRepository;
//import com.studywithus.repository.member.MemberRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.IntStream;
//
//@SpringBootTest
//@WebAppConfiguration
//public class PostRepositoryTest {
//    @Autowired
//    private PostRepository postRepository;
//    @Autowired
//    private MemberRepository memberRepository;
//
//    // getPost()
//    @Transactional
//    @Test
//    public void testGetPost() {
//        Pageable pageable = PageRequest.of(0, 10, Sort.by("post_id").descending());
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
//            postRepository.save(post);
//        });
//
//        System.out.println("=========================================");
//        List<Post> result = postRepository.getPost();
//        System.out.println(result);
////        result.get().forEach(row -> {
////            Object[] arr = (Object[]) row;
////            System.out.println(Arrays.toString(arr));
////        });
//    }
//
//    // getPostByPostID(post_id)
//    @Transactional
//    @Test
//    public void testGetPostByPostID() {
//        IntStream.rangeClosed(1, 5).forEach(i -> {
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
//            postRepository.save(post);
//        });
//
//        System.out.println("=========================================");
//        Object result = postRepository.getPostByPostId(3L);
//        System.out.println(result);
//    }
//
////    @Transactional
////    @Test
////    public void testGetPostByCategory() {
////        IntStream.rangeClosed(1, 5).forEach(i -> {
////            Member member = Member.builder()
////                    .email("user" + i + "@aaa.com")
////                    .nickname("user" + i)
////                    .password("1234")
////                    .bornDate("2000.01.01")
////                    .build();
//////            memberRepository.save(member);
////
////            Post post = Post.builder()
////                    .writer(member)
////                    .title(i + " title")
////                    .category(Category.notice)
////                    .content(i + " content")
////                    .build();
////            postRepository.save(post);
////        });
////
////        System.out.println("=========================================");
////        Object result = postRepository.getPostByCategory("notice");
////        ArrayList arr = (ArrayList) result;
////        for (int i = 0; i<arr.size(); i++) {
////            System.out.println(arr.get(i));
////        }
////    }
//
//    @Test
//    @Transactional
//    public void testGetList() {
//        IntStream.rangeClosed(1, 5).forEach(i -> {
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
//            postRepository.save(post);
//        });
//        IntStream.rangeClosed(6, 10).forEach(i -> {
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
//                    .category(Category.free)
//                    .content(i + " content")
//                    .build();
//            postRepository.save(post);
//        });
//
//        Pageable pageable = PageRequest.of(0, 10, Sort.by("post_id").descending().and(Sort.by("title").ascending()));
//        Page<Object[]> result = postRepository.getPostsByCategory("free", pageable);
//    }
//}
//
//