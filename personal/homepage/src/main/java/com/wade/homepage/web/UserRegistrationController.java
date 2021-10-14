package com.wade.homepage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "registration";
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
}
