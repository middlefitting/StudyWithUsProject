package com.studywithus.repository.board;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class PostRepositoryCustomImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public PostRepositoryCustomImpl(Class<?> domainClass) {
        super(domainClass);
    }
}
