package com.example.redis.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
    private String msgCode = "404";
    private String exceptionMessage = "Resource not found";

    public ResourceNotFoundException(){

    }

    public ResourceNotFoundException(String msgCode, String exceptionMessage){
        super(exceptionMessage);
        this.msgCode = msgCode;
        this.exceptionMessage = exceptionMessage;
    }
}
