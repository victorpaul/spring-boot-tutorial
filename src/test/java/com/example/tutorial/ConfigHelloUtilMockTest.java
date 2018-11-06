package com.example.tutorial;

import com.example.tutorial.util.DBUtil;
import com.example.tutorial.util.HelloUtil;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("mock-hello-util")
@Configuration
public class ConfigHelloUtilMockTest {

    @Bean
    @Primary
    public HelloUtil mockHelloUtil() {
        return Mockito.mock(HelloUtil.class);
    }

    @Bean
    @Primary
    public DBUtil mockDBUtil() {
        return Mockito.mock(DBUtil.class);
    }
}