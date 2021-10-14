package com.wade.spring.examples.mvc.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import java.net.URL;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class GreetingControllerTest {
	@InjectMocks
    private GreetingController controller;
	@Mock
	Model model;
	@LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	void testGreeting() {
		String result = controller.greeting("name", model);
		assertEquals("greeting",result);
		verify(model).addAttribute("name", "name");
	}
	
	@Test
    public void testHomeUrl1() throws Exception {
        String url = new URL("http://localhost:" + port + "/greeting").toString();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertTrue(response.getBody().contains("World"));

    }
	
	@Test
	public void testHomeUrl2() throws Exception {
		String url = new URL("http://localhost:" + port + "/greeting?name=chris").toString();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		assertTrue(response.getBody().contains("chris"));
		
	}
}
