package com.example.redis.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private Category category;
    private String code;
    private String description;
    private Double price;
    private Integer quantity;
    private List<String> imgUrls;
    private String rating;
    @CreatedDate
    private String createdAt;
    @LastModifiedDate
    private String updatedAt;
    private Boolean available;
}
