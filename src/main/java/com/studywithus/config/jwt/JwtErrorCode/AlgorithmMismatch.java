package com.studywithus.config.jwt.JwtErrorCode;

public interface AlgorithmMismatch {
    String code = "AlgorithmMismatchException";
    String message = "잘못된 알고리즘의 토큰";
    String status = "401";
}
