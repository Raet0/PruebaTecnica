package com.company.vehicles.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

public class StatusController {
    @GetMapping("/api/status")
    public Map<String, Object> status(){
        return Map.of(
            "service", "Spring Boot API",
                "status", "running",
                "timestamp", LocalDateTime.now().toString()
        );
    }
    
}
