package com.wade.spring.examples.SpringWIthAngular;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	@RequestMapping("/")
	public String greet() {
		return "welcome!";
	}
}
