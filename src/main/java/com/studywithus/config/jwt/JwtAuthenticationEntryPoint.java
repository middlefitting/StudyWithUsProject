package com.studywithus.config.jwt;

import com.studywithus.config.jwt.JwtErrorCode.*;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//CustomAuthenticationEntryPoint.java
@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        String exception = (String)request.getAttribute("exception");

        if(exception == null) {
            setResponse(response, UNKNOWN_ERROR.code, UNKNOWN_ERROR.message, UNKNOWN_ERROR.status);
        }
        else if(exception.equals(AlgorithmMismatch.code)) {
            setResponse(response, AlgorithmMismatch.code, AlgorithmMismatch.message, AlgorithmMismatch.status);
        }
        else if(exception.equals(TokenExpired.code)) {
            setResponse(response, TokenExpired.code, TokenExpired.message, TokenExpired.status);
        }
        else if(exception.equals(InvalidClaim.code)) {
            setResponse(response, InvalidClaim.code, InvalidClaim.message, InvalidClaim.status);
        }
        else if(exception.equals(SignatureVerification.code)) {
            setResponse(response, SignatureVerification.code, SignatureVerification.message, SignatureVerification.status);
        }
        else if(exception.equals(JWTVerification.code)) {
            setResponse(response, JWTVerification.code, JWTVerification.message, JWTVerification.status);
        }
        else if(exception.equals(UNKNOWN_ERROR.code)) {
            setResponse(response, UNKNOWN_ERROR.code, UNKNOWN_ERROR.message, UNKNOWN_ERROR.status);
        }
        else if(exception.equals(LOGIN_ERROR.code)) {
            setResponse(response, LOGIN_ERROR.code, LOGIN_ERROR.message, LOGIN_ERROR.status);
        }
        else {
            setResponse(response, UNKNOWN_ERROR.code, UNKNOWN_ERROR.message, UNKNOWN_ERROR.status);
        }
    }
    //한글 출력을 위해 getWriter() 사용
    private void setResponse(HttpServletResponse response, String code, String message, String status) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        JSONObject responseJson = new JSONObject();
        responseJson.put("code", code);
        responseJson.put("message", message);
        responseJson.put("status", status);

        response.getWriter().print(responseJson);
    }
}