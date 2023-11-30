package com.spring.security.controller;


import com.spring.security.model.User;
import com.spring.security.service.RoleService;
import com.spring.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RoleService roleService;
    private final UserService userService;

    public AdminController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }


    @GetMapping()
    public String getUsers(@ModelAttribute("user") User user, Model model,
                           Principal principal) {

        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("usingUser", userService.getUserByUsername(principal.getName()));
        return "admin";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "redirect:/admin";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id) {

        userService.updateUser(id, user);
        return "redirect:/admin";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }
}
