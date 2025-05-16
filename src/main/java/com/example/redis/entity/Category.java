package com.example.redis.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "categories")
public class Category {
    private String id;
    private String name;
    private String description;
    @CreatedDate
    private String createdAt;
    @LastModifiedDate
    private String updatedAt;
}
