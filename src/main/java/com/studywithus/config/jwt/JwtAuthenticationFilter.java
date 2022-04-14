package com.studywithus.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studywithus.config.jwt.JwtErrorCode.LOGIN_ERROR;
import com.studywithus.domain.entity.member.Member;
import com.studywithus.domain.service.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            ObjectMapper om = new ObjectMapper();
            Member member = om.readValue(request.getInputStream(), Member.class);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(member.getEmail(), member.getPassword());

            Authentication authentication = authenticationManager.authenticate(authenticationToken);


            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();

            //로그인 시 아이디 닉네임 반환해줌
            response.setContentType("application/json;charset=UTF-8");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("id", String.valueOf(principalDetails.getMember().getId()));
            hashMap.put("email", principalDetails.getMember().getEmail());
            hashMap.put("nickname", principalDetails.getMember().getNickname());
//            JSONObject responseJson = new JSONObject(hashMap);
//            response.getWriter().print(responseJson);
            //Recompile with -Xlint:unchecked for details.
            JSONObject responseJson = new JSONObject();
            responseJson.put("data", hashMap);
            responseJson.put("message", "login success");
            responseJson.put("status", "success");
            response.getWriter().print(responseJson);


            return authentication;

        } catch (IOException e) {
            //적용되지 않음
            request.setAttribute("exception", LOGIN_ERROR.code);
        }

        return null;
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal(); //이걸 통해 토큰을 만든다 //authResult:authentication 객체

        //Hash 암호화 방식
        String jwtToken = JWT.create()
                .withSubject("cos")
//                .withIssuedAt(new Date()) //내가 추가함
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME)) //만료시간 //10분
                .withClaim("id", principalDetails.getMember().getId())
                .withClaim("email", principalDetails.getMember().getEmail())
                .sign(Algorithm.HMAC512(JwtProperties.SECRET)); //secret 값


        String jwtRefreshToken = JWT.create()
                .withSubject("refresh")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME*6))
                .withClaim("id", principalDetails.getMember().getId())
                .withClaim("email", principalDetails.getMember().getEmail())
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));


        response.addHeader(JwtProperties.HEADER_STRING,JwtProperties.TOKEN_PREFIX + jwtToken);
//        response.addHeader("Refresh",JwtProperties.TOKEN_PREFIX + jwtRefreshToken);

    }
}
