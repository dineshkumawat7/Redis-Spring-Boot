package com.example.redis.model.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonErrorResponse {
    private String timestamp;
    private String status;
    private String statusCode;
    private String message;
}
