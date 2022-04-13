package com.studywithus.domain.service.board;

import com.studywithus.domain.entity.board.Comment;
import com.studywithus.domain.entity.board.P_like;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.web.controller.board.dto.CommentDto;
import com.studywithus.web.controller.board.dto.P_likeDto;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface P_likeService {
    Long register(P_likeDto p_likeDto);
    ArrayList<Object> getListAndCount(@Param("post_id") Long post_id);
    void remove(Long like_id);

    P_like dtoToEntity(P_likeDto dto);
    P_likeDto entityToDto(P_like p_like, Member member);
//    default P_like dtoToEntity(P_likeDto dto) {
//        Member member = Member.builder().id(dto.getMember_id()).build();
//        P_like p_like = P_like.builder()
//                .like_id(dto.getLike_id())
//                .post_id(dto.getPost_id())
//                .mem_id(member)
//                .build();
//        return p_like;
//    }
//
//    default P_likeDto entityToDto(P_like p_like, Member member) {
//        P_likeDto p_likeDto = P_likeDto.builder()
//                .like_id(p_like.getLike_id())
//                .member_id(member.getId())
//                .post_id(p_like.getPost_id())
//                .modDate(p_like.getModDate())
//                .regDate(p_like.getRegDate())
//                .build();
//        return p_likeDto;
//    }
}
