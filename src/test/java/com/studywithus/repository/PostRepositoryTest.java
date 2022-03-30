package com.studywithus.repository;

import com.studywithus.domain.board.Post;
import com.studywithus.domain.member.Member;
import com.studywithus.repository.board.Post.PostRepository;
import com.studywithus.repository.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

//@SpringBootTest
//public class MemberRepostoryTest {
//    private MemberRepository
//}

@SpringBootTest
@WebAppConfiguration
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Post post = Post.builder()
                    .title(i + " title")
                    .content(i + " content")
                    .build();
            postRepository.save(post);
        });
    }

    @Transactional
    @Test
    public void test() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Member member = Member.builder()
                    .email("user" + i + "@aaa.com")
                    .nickname("user" + i)
                    .password("1234")
                    .bornDate("2000.01.01")
                    .build();
            memberRepository.save(member);

            Post post = Post.builder()
                    .title(i + " title")
                    .content(i + " content")
                    .build();
            postRepository.save(post);
        });
    }

    @Test
    public void testGetPost() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
//            Member member = new Member("user"+i+"@aaa.com", "user"+i, "1234", "2000.01.01");
            Member member = Member.builder()
                    .email("user" + i + "@aaa.com")
                    .nickname("user" + i)
                    .password("1234")
                    .bornDate("2000.01.01")
                    .build();
//            memberRepository.save(member);

            Post post = Post.builder()
                    .mem_id(member)
                    .title(i + " title")
                    .content(i + " content")
                    .build();
            postRepository.save(post);
        });

        System.out.println("------------------");
        System.out.println(memberRepository.findByEmail("user38@aaa.com"));

        List<Post> result1 =  postRepository.getPost(4L);

        System.out.println("------------------");
        System.out.println(result1);

        Object result2 = postRepository.getPostWithWriter(30L);

        System.out.println("------------------");
        System.out.println(result2);
    }
}

