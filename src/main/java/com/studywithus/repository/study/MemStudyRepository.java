package com.studywithus.repository.study;

import com.studywithus.domain.study.MemStudy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemStudyRepository extends JpaRepository<MemStudy, Long>, MemStudyRepositoryCustom {
}
