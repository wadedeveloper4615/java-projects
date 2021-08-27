package com.wade.spring.examples.mvc.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class IndexControllerTest {
	@Autowired
	IndexController controller;
	@LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    
	@Test
	void testHome() {
		assertEquals("index",controller.home());
	}
	
	@Test
    public void testHomeUrl() throws Exception {
        String url = new URL("http://localhost:" + port + "/").toString();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertTrue(response.getBody().contains("<html>"));

    }
}
