package com.studywithus.domain.repository.board.Comment;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import com.studywithus.domain.entity.board.Comment;
import com.studywithus.domain.entity.board.QComment;
import com.studywithus.domain.entity.member.QMember;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.transaction.Transactional;
import java.util.List;

public class CommentRepositoryImpl extends QuerydslRepositorySupport implements CommentRepositoryCustom {

    public CommentRepositoryImpl() {
        super(Comment.class);
    }

    QComment comment = QComment.comment;
    QMember member = QMember.member;

    @Override
    public List<Tuple> getComments(Long post_id) {
        JPQLQuery<Comment> jpqlQuery = from(comment);
        jpqlQuery.leftJoin(member).on(comment.mem_id.eq(member));
        JPQLQuery<Tuple> tuple = jpqlQuery.select(comment, member);
        tuple.where(comment.post_id.eq(post_id));
        tuple.orderBy(comment.regDate.desc());

        return tuple.fetch();
    }

    @Transactional
    @Override
    public void deleteByCommentId(Long comment_id) {
        delete(comment).where(comment.comment_id.eq(comment_id)).execute();
    }
}
