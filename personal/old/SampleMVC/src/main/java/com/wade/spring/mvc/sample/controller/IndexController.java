package com.wade.spring.mvc.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.spring.mvc.sample.perisistence.entity.User;
import com.wade.spring.mvc.sample.perisistence.repository.UserRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@SuppressWarnings("unused")
public class IndexController {
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Autowired
    private UserRepository userRepository;
	
	@RequestMapping("/")
    public String index() {
		List<User> list = (List<User>) userRepository.findAll();
        return "index";
    }

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
