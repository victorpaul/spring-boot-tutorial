package com.example.tutorial.controller;

import com.example.tutorial.util.DBUtil;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("mock-hello-util")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HealthControllerMockTest {

    @Autowired
    private TestRestTemplate rest;

    @Autowired
    private DBUtil dbUtil;

    @Test
    public void healthCheck() throws JSONException {

        Mockito.when(dbUtil.getHealthStatus()).thenReturn("connection to db is established");

        ResponseEntity<String> response = rest.exchange("/api/health", HttpMethod.GET, new HttpEntity<String>(null, null), String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals("{\"db\":\"connection to db is established\"}", response.getBody(), false);

    }
}
