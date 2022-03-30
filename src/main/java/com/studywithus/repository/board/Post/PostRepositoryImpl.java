package com.studywithus.repository.board.Post;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studywithus.domain.board.Post;

import com.studywithus.domain.board.QPost;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class PostRepositoryImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {

    public PostRepositoryImpl() {
        super(Post.class);
    }

//    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> getPost(Long post_id) {

        QPost post = QPost.post;
        JPQLQuery<Post> jpqlQuery = from(post);
        jpqlQuery.select(post).where(post.post_id.eq(post_id));

        log.info("------------------------------");
        log.info(jpqlQuery);
        log.info("------------------------------");
        List<Post> result = jpqlQuery.fetch();

        return result;
    }

    @Override
    public Object getPostWithWriter(Long post_id) {
        QPost post = QPost.post;
        JPQLQuery<Post> jpqlQuery = from(post);
        jpqlQuery.leftJoin(post.mem_id);
        jpqlQuery.select(post, post.mem_id).where(post.post_id.eq(post_id));
        Object result = jpqlQuery.fetch();

        return result;
    }
}