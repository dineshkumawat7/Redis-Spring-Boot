package com.example.redis.exception;

import com.example.redis.model.common.CommonErrorResponse;
import com.example.redis.utils.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<CommonErrorResponse> handleServiceException(ServiceException exception) {
        CommonErrorResponse errorResponse = CommonErrorResponse.builder()
                .timestamp(String.valueOf(LocalDateTime.now()))
                .status(Constants.FAILURE)
                .statusCode(exception.getMsgCode())
                .message(exception.getExceptionMessage())
                .build();
        return ResponseEntity.status(Integer.parseInt(exception.getMsgCode())).body(errorResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CommonErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {
        CommonErrorResponse errorResponse = CommonErrorResponse.builder()
                .timestamp(String.valueOf(LocalDateTime.now()))
                .status(Constants.FAILURE)
                .statusCode(exception.getMsgCode())
                .message(exception.getExceptionMessage())
                .build();
        return ResponseEntity.status(Integer.parseInt(exception.getMsgCode())).body(errorResponse);
    }
}
