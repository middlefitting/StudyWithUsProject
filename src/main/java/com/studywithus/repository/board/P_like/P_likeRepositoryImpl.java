package com.studywithus.repository.board.P_like;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class P_likeRepositoryImpl extends QuerydslRepositorySupport implements P_likeRepositoryCustom {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public P_likeRepositoryImpl(Class<?> domainClass) {
        super(domainClass);
    }
}
