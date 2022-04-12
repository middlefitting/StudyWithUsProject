package com.studywithus.web.exhandler.advice;

import com.studywithus.web.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@Slf4j
@RestControllerAdvice(basePackages = "com.studywithus.web.controller.board")
public class ExControllerAdviceBoard {

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(DefaultHandlerExceptionResolver.class)
//    public ErrorResult DefaultHandlerException(DefaultHandlerExceptionResolver e) {
//        log.error("[exceptionHandler] ex", e);
//        return new ErrorResult("BAD_REQUEST", e.getMessage(), "400");
//    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalArgumentException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("BAD_REQUEST", e.getMessage(), "400");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ErrorResult runtimeExHandler(RuntimeException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("BAD_REQUEST", "정상적이지 않은 접근", "400");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResult exHandler(Exception e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("UNKNOWN_ERROR", "내부 서버 오류", "500");
    }



}