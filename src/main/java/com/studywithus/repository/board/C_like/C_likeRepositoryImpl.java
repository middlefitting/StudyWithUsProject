package com.studywithus.repository.board.C_like;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class C_likeRepositoryImpl extends QuerydslRepositorySupport implements C_likeRepositoryCustom {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public C_likeRepositoryImpl(Class<?> domainClass) {
        super(domainClass);
    }
}
