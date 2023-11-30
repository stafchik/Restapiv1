package com.spring.security.controller;


import com.spring.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public String getUsers(Model model, Principal principal) {
        model.addAttribute("usingUser", userService.getUserByUsername(principal.getName()));
        return "user";
    }

}