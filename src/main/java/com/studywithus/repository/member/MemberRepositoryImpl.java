//package com.studywithus.repository.member;
//
//import com.querydsl.jpa.JPQLQuery;
//import com.studywithus.domain.member.Member;
//import com.studywithus.domain.member.QMember;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//@Log4j2
//public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberRepositoryCustom {
//
//    public MemberRepositoryImpl(EntityManager em) {
//        super(Member.class);
//    }
//
//    QMember member = QMember.member;
//    //password 반환 조심
//    @Override
//    public List<Member> findByEmailPassword(String email, String password){
//        JPQLQuery<Member> jpqlQuery = from(member);
//        jpqlQuery.select(member).where(member.email.eq(email).and(member.password.eq(password)));
//
//        List<Member> result = jpqlQuery.fetch();
//        return result;
//    }
//
//    //password 반환 조심
//    @Override
//    public List<Member> findByEmail(String email){
//        JPQLQuery<Member> jpqlQuery = from(member);
//        jpqlQuery.select(member).where(member.email.eq(email));
//
//        List<Member> result = jpqlQuery.fetch();
//        return result;
//    }
//
//    //password 반환 조심
//    @Override
//    public List<Member> findAll(){
//        JPQLQuery<Member> jpqlQuery = from(member).select(member);
//
//        List<Member> result = jpqlQuery.fetch();
//        return result;
//    }
//}
