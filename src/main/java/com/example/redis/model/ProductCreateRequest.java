package com.example.redis.model;

import com.example.redis.entity.Category;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateRequest {
    private String name;
    private Category category;
    private String code;
    private String description;
    private Double price;
    private Integer quantity;
    private List<String> imgUrls;
    private String rating;
}
