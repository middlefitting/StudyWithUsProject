package com.studywithus.config.jwt.JwtErrorCode;

public interface LOGIN_ERROR {
    String code = "LOGIN_ERROR";
    String message = "아이디 혹은 비밀번호가 잘못되었습니다!";
    String status = "401";
}
