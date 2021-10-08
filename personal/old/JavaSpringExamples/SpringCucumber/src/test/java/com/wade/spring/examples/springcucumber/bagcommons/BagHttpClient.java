package com.wade.spring.examples.springcucumber.bagcommons;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.wade.spring.examples.SpringCucumber.Bag;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class BagHttpClient {

	private final String SERVER_URL = "http://localhost";
	private final String THINGS_ENDPOINT = "/things";

	@LocalServerPort
	private int port;
	private final RestTemplate restTemplate = new RestTemplate();

	public void clean() {
		restTemplate.delete(thingsEndpoint());
	}

	public Bag getContents() {
		return restTemplate.getForEntity(thingsEndpoint(), Bag.class).getBody();
	}

	public int put(final String something) {
		return restTemplate.postForEntity(thingsEndpoint(), something, Void.class).getStatusCodeValue();
	}

	private String thingsEndpoint() {
		return SERVER_URL + ":" + port + THINGS_ENDPOINT;
	}

}
