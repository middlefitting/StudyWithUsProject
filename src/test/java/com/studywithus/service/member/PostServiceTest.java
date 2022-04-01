package com.studywithus.service.member;

import com.studywithus.controller.board.dto.PostDto;
import com.studywithus.domain.member.Member;
import com.studywithus.repository.board.Post.PostRepository;
import com.studywithus.service.board.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    // 등록
    @Test
    public void testRegister() {
        Member member = Member.builder()
                .nickname("Test User")
                .email("test@aaa.com")
                .build();

        PostDto dto = PostDto.builder()
                .title("test.")
                .content("Test Test Test")
                .writer_nickname(member.getNickname())
                .build();

        Long post_id = postService.register(dto);
        System.out.println("===========================");
        System.out.println(post_id);

        Object result = postRepository.getPostByPostId(post_id);
        System.out.println("===========================");
        System.out.println(result);
    }
}
