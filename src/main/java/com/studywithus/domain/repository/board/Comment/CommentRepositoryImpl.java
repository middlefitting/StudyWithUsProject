package com.studywithus.domain.repository.board.Comment;

import com.studywithus.domain.entity.board.Comment;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class CommentRepositoryImpl extends QuerydslRepositorySupport implements CommentRepositoryCustom {

    public CommentRepositoryImpl() {
        super(Comment.class);
    }
}
