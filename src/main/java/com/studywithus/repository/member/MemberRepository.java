package com.studywithus.repository.member;

import com.studywithus.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
//@RequiredArgsConstructor
public interface MemberRepository extends JpaRepository<Member, Long> {  //MemberRepositoryCustom
    //    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);
//    List<Member> findByUsername(@Param("username") String username); //: jpql 있으면 네임드 어노테이션 파람이 넘어가야 한다

}
