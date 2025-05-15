package com.example.redis.controller;

import com.example.redis.entity.Category;
import com.example.redis.exception.ServiceException;
import com.example.redis.model.CategoryCreateRequest;
import com.example.redis.model.common.CommonSuccessResponse;
import com.example.redis.service.CategoryService;
import com.example.redis.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/redis/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CommonSuccessResponse<Category>> createNewCategory(@RequestBody CategoryCreateRequest categoryCreateRequest){
        Category createdCategory = categoryService.createCategory(categoryCreateRequest);
        String msg = "New category created successfully";
        return getSpecificResponse(msg, Constants.CREATED_STATUS_CODE ,createdCategory);
    }

    private <T> ResponseEntity<CommonSuccessResponse<T>> getSpecificResponse(String msg, String statusCode, T payload) {
        try {
            CommonSuccessResponse<T> response = CommonSuccessResponse.<T>builder()
                    .timestamp(String.valueOf(LocalDateTime.now()))
                    .status(Constants.SUCCESS)
                    .statusCode(statusCode)
                    .message(msg)
                    .payload(payload)
                    .build();
            return ResponseEntity.status(Integer.parseInt(statusCode)).body(response);
        } catch (Exception e) {
            throw new ServiceException(Constants.INTERNAL_SERVER_ERROR_STATUS_CODE, e.getMessage());
        }
    }
}
