package com.studywithus.service.board;

import com.studywithus.domain.entity.board.Post;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.dto.board.post.PostSaveRequestDto;
import com.studywithus.domain.repository.board.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl {
    private final PostRepository postRepository;

    // C
    public Long createPost(PostSaveRequestDto postSaveRequestDto) {
        return postRepository.save(postSaveRequestDto.toEntity()).getPost_id();
    }

    // R - All
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }


    public Page<Post> findPostList(Pageable pageable) {
        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize());

        return postRepository.findAll(pageable);
    }

    public Post findPostById(Long post_id) {
        return postRepository.findById(post_id).orElse(new Post());
    }

    public Optional<Post> findForId(Long id) {
        return postRepository.findById(id);
    }

    /*public PostSaveRequestDto registerPost(PostSaveRequestDto postSaveRequestDto) {
        Post post = new Post();
        post.setTitle(postSaveRequestDto.getTitle());
        post.setBody(postSaveRequestDto.getBody());
        post.setUser(new Member(1L)); // temporary code
        return new PostSaveRequestDto(postRepository.saveAndFlush(post));
    }*/

    /*public Page<Post> findByUserOrderedByCreatedDatePageable(Member member, Pageable pageable) {
        return postRepository.findByUserOrderByCreatedDateDesc(member, pageable);
    }*/

    public Page<Post> findAllByOrderByCreatedDateDescPageable(Pageable pageable) {
        return postRepository.findAllByOrderByCreatedDateDesc(pageable);
    }

    /*public Optional<PostDto> editPost(PostDto editPostDto) {
        return this.findForId(editPostDto.getId())
                .map(p -> {
                    p.setTitle(editPostDto.getTitle());
                    p.setBody(editPostDto.getBody());
                    return p;
                })
                .map(PostDto::new);
    }
*/
    // d
    public void delete(Post post) {
        postRepository.delete(post);
    }
}
