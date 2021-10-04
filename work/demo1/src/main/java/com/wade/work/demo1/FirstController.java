package com.wade.work.demo1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo1")
public class FirstController {
	@RequestMapping("method1")
	public String service1(){
		return "Demo1.method1";
	}
}
