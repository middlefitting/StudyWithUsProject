package com.studywithus.repository.board;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class P_likeRepositoryCustomImpl extends QuerydslRepositorySupport implements P_likeRepositoryCustom {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public P_likeRepositoryCustomImpl(Class<?> domainClass) {
        super(domainClass);
    }
}
