package com.studywithus.repository.board;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class CommentRepositoryCustomImpl extends QuerydslRepositorySupport implements CommentRepositoryCustom {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public CommentRepositoryCustomImpl(Class<?> domainClass) {
        super(domainClass);
    }
}
