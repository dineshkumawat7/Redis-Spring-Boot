package com.example.redis.service;

import com.example.redis.entity.Product;
import com.example.redis.model.ProductCreateRequest;

public interface ProductService {
    Product createProduct(ProductCreateRequest productCreateRequest);
}
