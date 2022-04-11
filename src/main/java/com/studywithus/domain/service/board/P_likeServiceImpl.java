package com.studywithus.domain.service.board;

import com.querydsl.core.Tuple;
import com.studywithus.domain.entity.board.Comment;
import com.studywithus.domain.entity.board.P_like;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.repository.board.P_like.P_likeRepository;
import com.studywithus.web.controller.board.dto.CommentDto;
import com.studywithus.web.controller.board.dto.P_likeDto;
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
public class P_likeServiceImpl implements P_likeService{

    private final P_likeRepository p_likeRepository;

    @Override
    public Long register(P_likeDto p_likeDto) {
        P_like p_like = dtoToEntity(p_likeDto);
        p_likeRepository.save(p_like);
        return p_like.getLike_id();
    }

    @Override
    public ArrayList<Object> getListAndCount(Long post_id) {
        ArrayList<Object> result = new ArrayList<>();
//        List<Tuple> dto = p_likeRepository.getP_like(post_id);
        List<Tuple> p_likeDto_before = p_likeRepository.getP_like(post_id);
        List arr = p_likeDto_before.stream().map(t -> t.toArray()).collect(Collectors.toList());
        Function<Object[], P_likeDto> fn = (en -> entityToDto((P_like) en[0], (Member) en[1]));
        ArrayList<P_likeDto> dto = (ArrayList<P_likeDto>) arr.stream().map(fn).collect(Collectors.toList());
        int cnt = dto.size();

        result.add(dto);
        result.add(cnt);

        return result;
    }

    @Override
    public void remove(Long like_id) {
        p_likeRepository.deleteById(like_id);
    }
}
