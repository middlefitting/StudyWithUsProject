//package com.studywithus.service.member;
//
//import com.studywithus.controller.board.dto.PageRequestDTO;
//import com.studywithus.controller.board.dto.PageResultDTO;
//import com.studywithus.controller.board.dto.PostDto;
//import com.studywithus.domain.entity.board.Category;
//import com.studywithus.domain.member.Member;
//import com.studywithus.repository.board.Post.PostRepository;
//import com.studywithus.service.board.PostService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.stream.IntStream;
//
//@SpringBootTest
//public class PostServiceTest {
//
//    @Autowired
//    private PostService postService;
//    @Autowired
//    private PostRepository postRepository;
//
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
////    // 조회
////    @Test
////    public void testList() {
////        IntStream.rangeClosed(1, 10).forEach(i -> {
////            Member member = Member.builder()
////                    .nickname("Test User" + i)
////                    .email("test"+i+"@aaa.com")
////                    .build();
////
////            PostDto dto = PostDto.builder()
////                    .title("test" + i)
////                    .content(i+" Test Test Test")
////                    .category(Category.notice)
////                    .writer_nickname(member.getNickname())
////                    .build();
////
////            Long post_id = postService.register(dto);
////            }
////        );
////        IntStream.rangeClosed(11, 20).forEach(i -> {
////                    Member member = Member.builder()
////                            .nickname("TestUser" + i)
////                            .email("test"+i+"@aaa.com")
////                            .build();
////
////                    PostDto dto = PostDto.builder()
////                            .title("test" + i)
////                            .content(i+" Test Test Test")
////                            .category(Category.free)
////                            .writer_id(member.getId())
////                            .build();
////
////                    Long post_id = postService.register(dto);
////                }
////        );
////
////        PageRequestDTO pageRequestDTO = new PageRequestDTO();
////        PageResultDTO<PostDto, Object[]> result = postService.getList("notice", pageRequestDTO);
////
////        for (PostDto postDto : result.getDtoList()) {
////            System.out.println(postDto);
////        }
////    }
//}
