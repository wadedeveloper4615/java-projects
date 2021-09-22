package com.wade.homepage.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.wade.homepage.model.User;
import com.wade.homepage.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
