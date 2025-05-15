package com.example.redis.service.impl;

import com.example.redis.entity.Category;
import com.example.redis.model.CategoryCreateRequest;
import com.example.redis.repository.CategoryRepo;
import com.example.redis.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category createCategory(CategoryCreateRequest categoryCreateRequest) {
        return null;
    }
}
