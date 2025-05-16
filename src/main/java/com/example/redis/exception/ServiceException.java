package com.example.redis.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException{
    private final String msgCode;
    private final String exceptionMessage;

    public ServiceException(String msgCode, String exceptionMessage){
        super(exceptionMessage);
        this.msgCode = msgCode;
        this.exceptionMessage = exceptionMessage;
    }
}
