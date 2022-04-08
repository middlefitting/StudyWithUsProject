package com.studywithus.config.jwt.JwtErrorCode;

public interface IllegalArgument {
    String code = "IllegalArgumentException";
    String message = "잘못된 인자의 토큰";
    String status = "401";
}
