/*
package com.studywithus.repository;

import com.studywithus.domain.entity.board.Category;
import com.studywithus.domain.entity.board.Comment;
import com.studywithus.domain.entity.board.Post;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.repository.board.Comment.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.stream.IntStream;

@SpringBootTest
@WebAppConfiguration
public class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void testCreate() {
        IntStream.rangeClosed(1, 50).forEach(i -> {
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
//            postRepository.save(post);
//            long bno = (long)(Math.random() * 20) + 1;

            Comment comment = Comment.builder()
                    .post_id(post)
                    .mem_id(member)
                    .content("comment.."+i)
                    .build();
            commentRepository.save(comment);
        });
    }
}
*/
