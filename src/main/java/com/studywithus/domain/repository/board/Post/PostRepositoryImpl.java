package com.studywithus.domain.repository.board.Post;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.studywithus.domain.entity.board.Category;
import com.studywithus.domain.entity.board.Post;

import com.studywithus.domain.entity.board.QPost;
import com.studywithus.domain.entity.member.QMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostRepositoryImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {

    public PostRepositoryImpl() {
        super(Post.class);
    }

    QPost post = QPost.post;
    QMember member = QMember.member;

    @Override
    public List<Tuple> getPost() {
        JPQLQuery<Post> jpqlQuery = from(post);
        jpqlQuery.leftJoin(member).on(post.writer.eq(member));
        JPQLQuery<Tuple> tuple = jpqlQuery.select(post, member.nickname);
        List<Tuple> result = tuple.fetch();

        ////////////////////
        for (Tuple tmp : result) {
            System.out.println(tmp);
        }
        ////////////////////
        return result;
    }

    @Override
    public Object getPostByPostId(Long post_id) {
        JPQLQuery<Post> jpqlQuery = from(post);
        jpqlQuery.leftJoin(member).on(post.writer.eq(member));
        JPQLQuery<Tuple> tuple = jpqlQuery.select(post, member).where(post.post_id.eq(post_id));
        Object result = tuple.fetch();

        return result;
    }

    @Override
    public Page<Object[]> getPostsByCategory(String category, Pageable pageable) {
        JPQLQuery<Post> jpqlQuery = from(post);
        jpqlQuery.leftJoin(member).on(post.writer.eq(member));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(post, member);
        tuple.where(post.category.eq(Category.valueOf(category)));

        // order by
        Sort sort = pageable.getSort();
        sort.stream().forEach(order -> {
            Order direction = order.isAscending() ? Order.ASC : Order.DESC;
            String prop = order.getProperty();

            PathBuilder orderByExpression = new PathBuilder(Post.class, "post");
            tuple.orderBy(new OrderSpecifier(direction, orderByExpression.get(prop)));
        });

        // page 처리
        tuple.offset(pageable.getOffset());
        tuple.limit(pageable.getPageSize());

        // fetch
        List<Tuple> result = tuple.fetch();
        ////////////////////
        System.out.println("================레파지토리 getPostsByCategory=================");
        System.out.println("전체");
        System.out.println(result);
        for (Tuple tmp : result) {
            System.out.println(tmp);
        }
        /////////////////////
        return new PageImpl<Object[]>(
                result.stream().map(t -> t.toArray()).collect(Collectors.toList()),
                pageable,
                jpqlQuery.fetchCount()
        );
    }
}