package com.wade.homepage.service;

import com.wade.homepage.model.User;

public interface UserService {
    User findByEmail(String email);

    void save(User user);
}
