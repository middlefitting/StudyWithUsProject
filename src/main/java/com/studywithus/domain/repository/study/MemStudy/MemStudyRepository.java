package com.studywithus.domain.repository.study.MemStudy;

import com.studywithus.domain.entity.study.MemStudy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemStudyRepository extends JpaRepository<MemStudy, Long>, MemStudyRepositoryCustom {
}
