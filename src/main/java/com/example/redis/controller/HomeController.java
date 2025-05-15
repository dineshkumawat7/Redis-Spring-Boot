package com.example.redis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/redis/")
public class HomeController {

    @GetMapping("/status")
    public ResponseEntity<Object> getStatus(){
        return ResponseEntity.status(HttpStatus.OK).body("Redis application running up ...");
    }
}
