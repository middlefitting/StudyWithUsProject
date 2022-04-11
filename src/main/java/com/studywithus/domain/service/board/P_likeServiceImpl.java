package com.studywithus.domain.service.board;

import com.studywithus.domain.repository.board.P_like.P_likeRepository;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class P_likeServiceImpl implements P_likeService {
    private P_likeRepository p_likeRepository;

    // Delete
    @Transactional
    @Override
    public Long remove(Long like_id) {
        p_likeRepository.deleteByPLikeId(like_id);
        return like_id;
    }
}
