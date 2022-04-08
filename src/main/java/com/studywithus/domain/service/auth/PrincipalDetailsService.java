package com.studywithus.domain.service.auth;


import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.repository.jwt.JwtMemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final JwtMemberRepository jwtMemberRepository;

    public PrincipalDetailsService(JwtMemberRepository jwtMemberRepository) {
        this.jwtMemberRepository = jwtMemberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> memberOptional = jwtMemberRepository.findByEmail(email);
        Member memberEntity = Optional.of(memberOptional.orElseGet(Member::new)).get();

        if (memberEntity.getEmail() != null) {
            return new PrincipalDetails(memberEntity);
        }
        return null;
    }
}
