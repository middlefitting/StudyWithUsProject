package com.studywithus.domain.service.board;

import com.querydsl.core.Tuple;
import com.studywithus.domain.entity.board.Comment;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.repository.board.Comment.CommentRepository;
import com.studywithus.domain.repository.member.MemberRepository;
import com.studywithus.web.controller.board.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    @Override
    public Long register(CommentDto commentDto) {
        Comment comment = dtoToEntity(commentDto);
        commentRepository.save(comment);
        return comment.getComment_id();
    }

    @Override
    public ArrayList<CommentDto> getList(Long post_id) {
        List<Tuple> result = commentRepository.getComments(post_id);
        List arr = result.stream().map(t -> t.toArray()).collect(Collectors.toList());
        Function<Object[], CommentDto> fn = (en -> entityToDto((Comment) en[0], (Member) en[1]));
        ArrayList<CommentDto> dto = (ArrayList<CommentDto>) arr.stream().map(fn).collect(Collectors.toList());

        return dto;
    }

    @Override
    public void remove(Long comment_id) {
        commentRepository.deleteById(comment_id);
    }

    @Override
    public Comment dtoToEntity(CommentDto dto) {
        Member member = memberRepository.findById(dto.getWriter_id()).orElse(null);
        Comment comment = Comment.builder()
                .post_id(dto.getPost_id())
                .mem_id(member)
                .content(dto.getContent())
                .build();
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public CommentDto entityToDto(Comment comment, Member member) {
        CommentDto commentDto = CommentDto.builder()
                .comment_id(comment.getComment_id())
                .post_id(comment.getPost_id())
                .writer_id(member.getId())
                .writer_nickname(member.getNickname())
                .content(comment.getContent())
                .modDate(comment.getModDate())
                .regDate(comment.getRegDate())
                .build();
        return commentDto;
    }


}
