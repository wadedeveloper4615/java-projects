package com.wade.home.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

class LoginControllerTest {
    private LoginController objectUnderTest;

    @Test
    void testLogin() {
        objectUnderTest = new LoginController();
        ModelAndView result = objectUnderTest.login();
        assertEquals("login",result.getViewName());
    }

    @Test
    void testRegistration() {
    }

    @Test
    void testCreateNewUser() {
    }

    @Test
    void testHome() {
    }

}
