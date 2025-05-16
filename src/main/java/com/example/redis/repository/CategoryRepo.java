package com.example.redis.repository;

import com.example.redis.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends MongoRepository<Category, String> {
    Optional<Category> findByName(String name);
}
