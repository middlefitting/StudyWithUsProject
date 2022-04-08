package com.studywithus.repository.study;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class StudyRepositoryCustomImpl extends QuerydslRepositorySupport implements StudyRepositoryCustom {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public StudyRepositoryCustomImpl(Class<?> domainClass) {
        super(domainClass);
    }
}