package com.studywithus.repository.study;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MemStudyRepositoryImpl extends QuerydslRepositorySupport implements MemStudyRepositoryCustom {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public MemStudyRepositoryImpl(Class<?> domainClass) {
        super(domainClass);
    }
}
