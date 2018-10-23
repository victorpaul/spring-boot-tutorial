package com.example.tutorial.util;

import org.springframework.stereotype.Component;

@Component
public class HelloUtilImpl implements HelloUtil {

    @Override
    public String getGreeting() {
        return "Hello world";
    }
}