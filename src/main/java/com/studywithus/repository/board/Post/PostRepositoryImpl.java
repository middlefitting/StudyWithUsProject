package com.studywithus.repository.board.Post;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studywithus.domain.board.Category;
import com.studywithus.domain.board.Post;

import com.studywithus.domain.board.QPost;
import com.studywithus.domain.member.QMember;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class PostRepositoryImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {

    public PostRepositoryImpl() {
        super(Post.class);
    }

//    private final JPAQueryFactory jpaQueryFactory;

    QPost post = QPost.post;
    QMember member = QMember.member;

    @Override
    public Object getPost() {
        JPQLQuery<Post> jpqlQuery = from(post);
        jpqlQuery.leftJoin(member).on(post.writer.eq(member));
        jpqlQuery.select(post, member.nickname);
        Object result = jpqlQuery.fetch();

        return result;
    }

    @Override
    public Object getPostByPostId(Long post_id) {
        JPQLQuery<Post> jpqlQuery = from(post);
        jpqlQuery.leftJoin(member).on(post.writer.eq(member));
        jpqlQuery.select(post, member.nickname, member.id).where(post.post_id.eq(post_id));
        Object result = jpqlQuery.fetch();

        return result;
    }

    @Override
    public Object getPostByCategory(String category) {
        JPQLQuery<Post> jpqlQuery = from(post);
        jpqlQuery.leftJoin(member).on(post.writer.eq(member));
        jpqlQuery.select(post, member.nickname, member.id).where(post.category.eq(Category.valueOf(category)));
        Object result = jpqlQuery.fetch();

        return result;
    }
}