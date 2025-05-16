package com.example.redis.service.impl;

import com.example.redis.entity.Category;
import com.example.redis.exception.ResourceNotFoundException;
import com.example.redis.exception.ServiceException;
import com.example.redis.model.CategoryCreateRequest;
import com.example.redis.repository.CategoryRepo;
import com.example.redis.service.CategoryService;
import com.example.redis.utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Log4j2
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Category createCategory(CategoryCreateRequest categoryCreateRequest) {
        try {

            Category category = null;
            if(categoryRepo.findByName(categoryCreateRequest.getName()).isPresent()){

            }
            category = Category.builder()
                    .id(UUID.randomUUID().toString().toLowerCase().replace("-", ""))
                    .name(categoryCreateRequest.getName())
                    .description(categoryCreateRequest.getDescription())
                    .createdAt(String.valueOf(LocalDateTime.now()))
                    .updatedAt(String.valueOf(LocalDateTime.now()))
                    .build();
            Category createdCategory = categoryRepo.save(category);
            log.info("New category created successfully ::: {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createdCategory));
            return createdCategory;
        } catch (Exception e) {
            throw new ServiceException(Constants.INTERNAL_SERVER_ERROR_STATUS_CODE, e.getMessage());
        }
    }

    @Override
    public Category getByIdOrName(String id, String name) {
        try{
            Category category = null;
            if(id != null && !(id.trim().isEmpty())){
                category = categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constants.RESOURCE_NOT_FOUND_STATUS_CODE,
                        String.format("Category not found with id: %s", id)));
            }
            if(name != null && !(name.trim().isEmpty())){
                category = categoryRepo.findByName(name).orElseThrow(() -> new ResourceNotFoundException(Constants.RESOURCE_NOT_FOUND_STATUS_CODE,
                        String.format("Category not found with name: %s", name)));
            }
          return category;
        } catch (ResourceNotFoundException e) {
            throw new ServiceException(e.getMsgCode(), e.getMessage());
        } catch (Exception e){
            throw new ServiceException(Constants.INTERNAL_SERVER_ERROR_STATUS_CODE, e.getMessage());
        }
    }

    @Override
    public void deleteCategory(String id) {
        try {
            Category category = categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constants.RESOURCE_NOT_FOUND_STATUS_CODE,
                    String.format("Category not found with id: %s", id)));
            if (category != null) {
                categoryRepo.delete(category);
            }
        } catch (ResourceNotFoundException e) {
            throw new ServiceException(e.getMsgCode(), e.getMessage());
        } catch (Exception e){
            throw new ServiceException(Constants.INTERNAL_SERVER_ERROR_STATUS_CODE, e.getMessage());
        }
    }
}
