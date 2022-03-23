package com.studywithus.repository.member;

import com.studywithus.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberJpaRepository {
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findById(Long id){
        return em.find(Member.class, id);
    }
    
    //password 반환 조심
    public Member findByEmailPassword(String email, String password){
        return em.createQuery("select m from Member m where m.email= :email and m.password= :password", Member.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
    }

    //password 반환 조심
    public Member findByEmail(String email){
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    //password 반환 조심
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }



}
