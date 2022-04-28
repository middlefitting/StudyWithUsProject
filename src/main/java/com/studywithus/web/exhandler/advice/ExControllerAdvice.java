package com.studywithus.web.exhandler.advice;

import com.auth0.jwt.exceptions.*;
import com.studywithus.web.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "com.studywithus.web.controller")
public class ExControllerAdvice {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AlgorithmMismatchException.class)
    public ErrorResult jwtDecodeExHandler(JWTDecodeException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("BAD_REQUEST", "잘못된 알고리즘의 토큰", "401");
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(TokenExpiredException.class)
    public ErrorResult jwtDecodeExHandler(TokenExpiredException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("BAD_REQUEST", "만료된 토큰", "401");
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidClaimException.class)
    public ErrorResult jwtDecodeExHandler(InvalidClaimException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("BAD_REQUEST", "경고 정상적이지 않은 토큰", "401");
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(SignatureVerificationException.class)
    public ErrorResult jwtDecodeExHandler(SignatureVerificationException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("BAD_REQUEST", "경고 정상적이지 않은 토큰", "401");
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(JWTVerificationException.class)
    public ErrorResult jwtDecodeExHandler(JWTVerificationException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("UNAUTHORIZED", "인증할 수 없는 토큰", "401");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalArgumentException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("BAD_REQUEST", e.getMessage(), "400");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ErrorResult runtimeExHandler(RuntimeException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("BAD_REQUEST", "정상적이지 않은 접근", "400");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorResult exHandler(Exception e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("UNKNOWN_ERROR", "내부 서버 오류", "500");
    }



}
