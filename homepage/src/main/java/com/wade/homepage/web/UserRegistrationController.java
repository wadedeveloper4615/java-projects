package com.wade.homepage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wade.homepage.service.RoleService;
import com.wade.homepage.service.UserService;
import com.wade.homepage.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PostMapping
    public String registerUserAccount(UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

    @GetMapping
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        UserRegistrationDto user = new UserRegistrationDto();
        modelAndView.addObject("user", user);
        modelAndView.addObject("roles", roleService.findAll());
        return modelAndView;
    }
}
