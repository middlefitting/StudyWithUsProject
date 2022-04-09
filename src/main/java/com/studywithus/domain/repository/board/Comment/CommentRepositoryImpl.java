package com.studywithus.domain.repository.board.Comment;

import com.studywithus.domain.entity.board.Comment;
import com.studywithus.domain.entity.board.QComment;
import com.studywithus.domain.entity.board.QPost;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class CommentRepositoryImpl extends QuerydslRepositorySupport implements CommentRepositoryCustom {

    public CommentRepositoryImpl() {
        super(Comment.class);
    }

    QComment comment = QComment.comment;
    QPost post = QPost.post;

//    @Override
//    public void deleteByPostId(Long post_id) {
//        delete(comment).where(comment.post_id.eq(post_id)).execute();
//    }
}
