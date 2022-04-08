package com.studywithus.config.jwt.JwtErrorCode;

public interface TokenExpired {
    String code = "TokenExpiredException";
    String message = "만료된 토큰";
    String status = "401";
}
