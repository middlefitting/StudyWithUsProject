package com.studywithus.config.jwt;

public interface JwtProperties {
    String SECRET = "studyWithUs";
    int EXPIRATION_TIME = 60000*10*6*6; //6시간
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
