package com.example.tutorial.controller;

import com.example.tutorial.util.HelloUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private HelloUtil helloUtil;

    @GetMapping("/api/hello")
    public Map<String, Object> getGreeting() {
        Map<String, Object> response = new HashMap<>();

        response.put("greeting", helloUtil.getGreeting());

        return response;
    }

}
