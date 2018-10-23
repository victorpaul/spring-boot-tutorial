package com.example.tutorial.controller;

import com.example.tutorial.util.HelloUtil;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("mock-hello-util")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerMockTest {

    @Autowired
    private TestRestTemplate rest;

    @Autowired
    private HelloUtil helloUtil;

    @Test
    public void contextLoads() throws JSONException {

        Mockito.when(helloUtil.getGreeting()).thenReturn("Hello mock");

        ResponseEntity<String> response = rest.exchange("/api/hello", HttpMethod.GET, new HttpEntity<String>(null, null), String.class);

        String expected = "{\"greeting\":\"Hello mock\"}";
        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

}
