package com.studywithus.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.*;
import com.studywithus.config.jwt.JwtErrorCode.*;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.repository.jwt.JwtMemberRepository;
import com.studywithus.domain.service.auth.PrincipalDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final JwtMemberRepository jwtMemberRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, JwtMemberRepository jwtMemberRepository) {
        super(authenticationManager);
        this.jwtMemberRepository = jwtMemberRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String jwtHeader = request.getHeader("Authorization");

        if(jwtHeader == null|| !jwtHeader.startsWith("Bearer ")){
            request.setAttribute("exception", AlgorithmMismatch.code);
            chain.doFilter(request,response);
            return;
        }

        String jwtToken = request.getHeader("Authorization").replace("Bearer ",""); //Bearer 및 공백을 제거해준다.


        try {
            String email = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken).getClaim("email").asString();

            if(email!=null){
                Optional<Member> memberOptional = jwtMemberRepository.findByEmail(email);
                Member memberEntity = Optional.of(memberOptional.orElseGet(Member::new)).get();
                PrincipalDetails principalDetails = new PrincipalDetails(memberEntity);
                Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());
                //강제로 시큐리티의 세션에 접근하여 Authentication 객체를 저장
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (AlgorithmMismatchException e) {
        request.setAttribute("exception", AlgorithmMismatch.code);
        } catch (TokenExpiredException e) {
            request.setAttribute("exception", TokenExpired.code);
        } catch (InvalidClaimException e) {
            request.setAttribute("exception", InvalidClaim.code);
        } catch (SignatureVerificationException e) {
            request.setAttribute("exception", SignatureVerification.code);
        } catch (JWTVerificationException e) {
            request.setAttribute("exception", JWTVerification.code);
        } catch (IllegalArgumentException e) {
            request.setAttribute("exception", IllegalArgument.code);
        } catch (Exception e) {
            log.error("token : {}", jwtToken);
            log.error(" JwtFilter - doFilterInternal() InternalUnknownException  - Exception Message : {}", e.getMessage());
            log.error("Exception StackTrace : {");
            e.printStackTrace();
            log.error("}");
            request.setAttribute("exception", UNKNOWN_ERROR.code);
        }
        chain.doFilter(request,response);

    }
}
