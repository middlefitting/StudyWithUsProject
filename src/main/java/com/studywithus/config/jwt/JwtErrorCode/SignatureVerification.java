package com.studywithus.config.jwt.JwtErrorCode;

public interface SignatureVerification {
    String code = "SignatureVerificationException";
    String message = "서명 인증이 안된 토큰";
    String status = "401";
}
