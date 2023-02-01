package com.example.demo.user.common.exception;

import com.example.demo.user.common.response.ErrorCode;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private ErrorCode errorCode;

    public BaseException() {
    }
    
}
