package com.example.redis.model.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonSuccessResponse<T> {
    private String timestamp;
    private String status;
    private String statusCode;
    private String message;
    private T payload;
}
