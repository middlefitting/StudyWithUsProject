package com.studywithus.repository.board.Post;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.studywithus.domain.board.Category;
import com.studywithus.domain.board.Post;

import com.studywithus.domain.board.QPost;
import com.studywithus.domain.member.QMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class PostRepositoryImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {

    public PostRepositoryImpl() {
        super(Post.class);
    }

    QPost post = QPost.post;
    QMember member = QMember.member;

    @Override
    public List<Post> getPost() {
        JPQLQuery<Post> jpqlQuery = from(post);
        jpqlQuery.leftJoin(member).on(post.writer.eq(member));
        jpqlQuery.select(post, member.nickname);

        List<Post> result = jpqlQuery.fetch();

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
    public Page<Object[]> getPostsByCategory(String category, Pageable pageable) {
        JPQLQuery<Post> jpqlQuery = from(post);
        jpqlQuery.leftJoin(member).on(post.writer.eq(member));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(post, member.nickname);
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
        for (Tuple tmp : result) {
            System.out.println(tmp);
        }
        /////////////////////
        return null;
    }
}