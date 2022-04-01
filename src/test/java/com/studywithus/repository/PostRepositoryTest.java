package com.studywithus.repository;

import com.studywithus.domain.board.Category;
import com.studywithus.domain.board.Post;
import com.studywithus.domain.member.Member;
import com.studywithus.repository.board.Post.PostRepository;
import com.studywithus.repository.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

@SpringBootTest
@WebAppConfiguration
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MemberRepository memberRepository;

    // getPost()
    @Transactional
    @Test
    public void testGetPost() {
        IntStream.rangeClosed(1, 5).forEach(i -> {
            Member member = Member.builder()
                    .email("user" + i + "@aaa.com")
                    .nickname("user" + i)
                    .password("1234")
                    .bornDate("2000.01.01")
                    .build();
//            memberRepository.save(member);

            Post post = Post.builder()
                    .writer(member)
                    .title(i + " title")
                    .category(Category.notice)
                    .content(i + " content")
                    .build();
            postRepository.save(post);
        });

        System.out.println("=========================================");
        Object result = postRepository.getPost();
        System.out.println(result);
    }

    // getPostByPostID(post_id)
    @Transactional
    @Test
    public void testGetPostByPostID() {
        IntStream.rangeClosed(1, 5).forEach(i -> {
            Member member = Member.builder()
                    .email("user" + i + "@aaa.com")
                    .nickname("user" + i)
                    .password("1234")
                    .bornDate("2000.01.01")
                    .build();
//            memberRepository.save(member);

            Post post = Post.builder()
                    .writer(member)
                    .title(i + " title")
                    .category(Category.notice)
                    .content(i + " content")
                    .build();
            postRepository.save(post);
        });

        System.out.println("=========================================");
        Object result = postRepository.getPostByPostId(3L);
        System.out.println(result);
    }
}


