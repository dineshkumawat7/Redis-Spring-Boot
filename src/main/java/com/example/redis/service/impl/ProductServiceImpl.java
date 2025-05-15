package com.example.redis.service.impl;

import com.example.redis.entity.Product;
import com.example.redis.model.ProductCreateRequest;
import com.example.redis.repository.CategoryRepo;
import com.example.redis.repository.ProductRepo;
import com.example.redis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Product createProduct(ProductCreateRequest productCreateRequest) {
        return null;
    }
}
