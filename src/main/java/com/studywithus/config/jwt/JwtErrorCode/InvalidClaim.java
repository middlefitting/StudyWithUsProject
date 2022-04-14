package com.studywithus.config.jwt.JwtErrorCode;

public interface InvalidClaim {
    String code = "InvalidClaimException";
    String message = "권한 없음";
    String status = "401";
}
