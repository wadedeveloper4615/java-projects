package com.gmail.christopher.app.security;

import com.gmail.christopher.backend.data.entity.User;

@FunctionalInterface
public interface CurrentUser {

	User getUser();
}
