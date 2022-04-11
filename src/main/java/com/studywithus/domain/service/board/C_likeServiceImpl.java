package com.studywithus.domain.service.board;

import com.studywithus.domain.repository.board.C_like.C_likeRepository;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class C_likeServiceImpl implements C_likeService {
    private final C_likeRepository c_likeRepository;

    // Delete
    @Transactional
    @Override
    public Long remove(Long like_id) {
        c_likeRepository.deleteByCLikeId(like_id);
        return like_id;
    }
}
