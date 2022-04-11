/*
package com.studywithus.service.member;


import com.studywithus.domain.entity.board.Category;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.repository.board.Post.PostRepository;
import com.studywithus.domain.service.board.PostService;
import com.studywithus.web.controller.board.dto.PageRequestDTO;
import com.studywithus.web.controller.board.dto.PageResultDTO;
import com.studywithus.web.controller.board.dto.PostDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

//    // 등록
//    @Test
//    public void testRegister() {
//        Member member = Member.builder()
//                .nickname("Test User")
//                .email("test@aaa.com")
//                .build();
//
//        PostDto dto = PostDto.builder()
//                .title("test.")
//                .content("Test Test Test")
//                .writer_nickname(member.getNickname())
//                .build();
//
//        Long post_id = postService.register(dto);
//        System.out.println("===========================");
//        System.out.println(post_id);
//
//        Object result = postRepository.getPostByPostId(post_id);
//        System.out.println("===========================");
//        System.out.println(result);
//    }
//
//    // 게시글 번호로 조회
//    @Test
//    public void testGet() {
//        IntStream.rangeClosed(1, 30).forEach(i -> {
//                    Member member = Member.builder()
//                            .nickname("User" + i)
//                            .email("test"+i+"@aaa.com")
//                            .build();
//
//                    PostDto dto = PostDto.builder()
//                            .title("test" + i)
//                            .content(i+" Test Test Test")
//                            .category(Category.notice)
//                            .writer_id(member.getId())
//                            .writer_nickname(member.getNickname())
//                            .build();
//
//                    Long post_id = postService.register(dto);
//                }
//        );
//
//        Long post_id = 23L;
//        PostDto postDto = postService.get(post_id);
//        System.out.println(postDto);
//    }

    // 전체 조회
    @Test
    public void testList() {
        IntStream.rangeClosed(1, 30).forEach(i -> {
            Member member = Member.builder()
                    .nickname("User" + i)
                    .email("test"+i+"@aaa.com")
                    .build();

            PostDto dto = PostDto.builder()
                    .title("test" + i)
                    .content(i+" Test Test Test")
                    .category(Category.notice)
                    .writer_id(member.getId())
                    .writer_nickname(member.getNickname())
                    .build();

            Long post_id = postService.register(dto);
            }
        );
        IntStream.rangeClosed(31, 60).forEach(i -> {
                    Member member = Member.builder()
                            .nickname("TestUser" + i)
                            .email("test"+i+"@aaa.com")
                            .build();

                    PostDto dto = PostDto.builder()
                            .title("test" + i)
                            .content(i+" Test Test Test")
                            .category(Category.free)
                            .writer_id(member.getId())
                            .writer_nickname(member.getNickname())
                            .build();

                    Long post_id = postService.register(dto);
                }
        );

        PageRequestDTO pageRequestDTO = new PageRequestDTO();
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(2).size(10).build();
        PageResultDTO<PostDto, Object[]> result = postService.getList(pageRequestDTO);

        for (PostDto postDto : result.getDtoList()) {
            System.out.println(postDto);
        }
        System.out.println("======================");
        System.out.println(result.isNext());
    }

    //수정
    @Test
    public void testUpdate() {
        IntStream.rangeClosed(1, 30).forEach(i -> {
                    Member member = Member.builder()
                            .nickname("User" + i)
                            .email("test" + i + "@aaa.com")
                            .build();

                    PostDto dto = PostDto.builder()
                            .title("test" + i)
                            .content(i + " Test Test Test")
                            .category(Category.notice)
                            .writer_id(member.getId())
                            .writer_nickname(member.getNickname())
                            .build();

                    Long post_id = postService.register(dto);
                }
        );

        PostDto dto = PostDto.builder()
                .post_id(3L)
                .title("test수정")
                .content("testtest수정")
                .build();
        postService.modify(dto);
    }

    //삭제
    @Test
    public void testDelete() {
        IntStream.rangeClosed(1, 30).forEach(i -> {
                    Member member = Member.builder()
                            .nickname("User" + i)
                            .email("test" + i + "@aaa.com")
                            .build();

                    PostDto dto = PostDto.builder()
                            .title("test" + i)
                            .content(i + " Test Test Test")
                            .category(Category.notice)
                            .writer_id(member.getId())
                            .writer_nickname(member.getNickname())
                            .build();

                    Long post_id = postService.register(dto);
                }
        );

        Long pno = 3L;
        postService.remove(pno);
    }
}
*/
