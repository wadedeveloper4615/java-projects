package com.wade.homepage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wade.homepage.dto.UserRegistrationDto;
import com.wade.homepage.model.User;
import com.wade.homepage.service.RoleService;
import com.wade.homepage.service.SecurityService;
import com.wade.homepage.service.UserService;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    @Qualifier("userValidator")
    private UserValidator userValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }
        // model.addAttribute("user", new UserRegistrationDto());
        model.addAttribute("roles", roleService.findAll());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") @Validated UserRegistrationDto registrationDto, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // model.addAttribute("user", new UserRegistrationDto());
            model.addAttribute("roles", roleService.findAll());
            return "registration";
        }
        User user = registrationDto.getUser();
        userService.save(user);
        securityService.autoLogin(user.getEmail(), user.getPasswordConfirm());
        return "redirect:/welcome";
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping({ "/", "/welcome" })
    public String welcome(Model model) {
        return "welcome";
    }
}
