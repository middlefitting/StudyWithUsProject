package com.studywithus.domain.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.studywithus.domain.entity.board.Post;
import com.studywithus.domain.entity.board.QPost;
import com.studywithus.domain.entity.member.QMember;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class SearchRepositoryImpl extends QuerydslRepositorySupport implements SearchRepositoryCustom {

    public SearchRepositoryImpl() {
        super(Post.class);
    }

    QPost post = QPost.post;
    QMember member = QMember.member;

    @Override
    public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
        JPQLQuery<Post> jpqlQuery = from(post);
        jpqlQuery.leftJoin(member).on(post.writer.eq(member));
        JPQLQuery<Tuple> tuple = jpqlQuery.select(post, member);

        // 조건 추가
        BooleanBuilder totalBuilder = new BooleanBuilder();
        BooleanExpression booleanExpression = post.post_id.gt(0L); // 쿼리 null 일 경우 대비

        totalBuilder.and(booleanExpression);
        if(type != null) {
            String[] typeArray = type.split("");
            BooleanBuilder addBuilder = new BooleanBuilder();
            for (String key : typeArray) {
                switch (key) {
                    case "t" : //title
                        addBuilder.or(post.title.contains(keyword));
                        break;
                    case "w" : //writer
                        addBuilder.or(member.nickname.contains(keyword));
                        break;
                    case "c" : //content
                        addBuilder.or(post.content.contains(keyword));
                        break;
                }
            }
            totalBuilder.and(addBuilder);
        }

        tuple.where(totalBuilder);

        // 정렬
        Sort sort = pageable.getSort();
        sort.stream().forEach(order -> {
            Order direction = order.isAscending() ? Order.ASC : Order.DESC;
            String prop = order.getProperty();
            PathBuilder orderByExpression = new PathBuilder(Post.class, "post");
            tuple.orderBy(new OrderSpecifier(direction, orderByExpression.get(prop)));
        });
        tuple.groupBy(post);

        List<Tuple> result = tuple.fetch();

        long count = tuple.fetchCount();
        return new PageImpl<Object[]>(
                result.stream().map(t -> t.toArray()).collect(Collectors.toList()), //dtoList
                pageable, //pageInfo
                count // count
        );
    }

//    @Override
//    public Post search() {
//        return null;
//    }
}
