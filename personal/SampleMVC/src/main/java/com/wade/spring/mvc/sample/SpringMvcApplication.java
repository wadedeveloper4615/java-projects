package com.wade.spring.mvc.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.wade")
@EntityScan("com.wade")
public class SpringMvcApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}
}
