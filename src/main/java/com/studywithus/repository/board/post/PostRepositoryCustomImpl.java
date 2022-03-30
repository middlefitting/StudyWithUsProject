package com.studywithus.repository.board.post;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studywithus.domain.board.Post;

import com.studywithus.domain.board.QPost;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.studywithus.domain.board.QPost.post;

public class PostRepositoryCustomImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public PostRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(Post.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Post> findByAll() {
        QPost qPost = post;

        return queryFactory
                .selectFrom(post)
                .fetch();
    }
}
