package com.spring.security.controller;

import com.spring.security.model.User;
import com.spring.security.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class RestUserController {
    private final UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public User showUser(Principal principal) {
        return userService.getUserByUsername(principal.getName());
    }
}
