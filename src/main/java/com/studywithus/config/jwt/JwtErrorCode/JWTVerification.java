package com.studywithus.config.jwt.JwtErrorCode;

public interface JWTVerification {
    String code = "JWTVerificationException";
    String message = "확인되지 않은 토큰";
    String status = "401";
}
