package com.example.redis.service;

import com.example.redis.entity.Category;
import com.example.redis.model.CategoryCreateRequest;

public interface CategoryService {
    Category createCategory(CategoryCreateRequest categoryCreateRequest);
}
