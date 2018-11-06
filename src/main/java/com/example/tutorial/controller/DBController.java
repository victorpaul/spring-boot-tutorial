package com.example.tutorial.controller;

import com.example.tutorial.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DBController {

    @Autowired
    private DBUtil dbUtil;

    @GetMapping("/api/health")
    public Map<String, Object> getHealth() {
        Map<String, Object> response = new HashMap<>();

        response.put("db", dbUtil.getHealthStatus());

        return response;
    }

}
