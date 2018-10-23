package com.example.tutorial.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @Autowired
    private TestRestTemplate rest;

    @Test
    public void contextLoads() throws JSONException {

        ResponseEntity<String> response = rest.exchange("/api/hello", HttpMethod.GET, new HttpEntity<String>(null, null), String.class);

        String expected = "{\"greeting\":\"Hello world\"}";
        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

}
