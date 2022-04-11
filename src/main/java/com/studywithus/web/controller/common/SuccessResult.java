package com.studywithus.web.controller.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuccessResult<T> {
    private T data;
    private String message;
    private String status;
}
