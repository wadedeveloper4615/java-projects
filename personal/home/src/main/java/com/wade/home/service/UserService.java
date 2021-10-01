package com.wade.home.service;

import com.wade.home.model.User;

public interface UserService {
    public User findUserByEmail(String email);

    public void saveUser(User user);
}
