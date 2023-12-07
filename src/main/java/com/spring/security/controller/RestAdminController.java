package com.spring.security.controller;

import com.spring.security.model.Role;
import com.spring.security.model.User;

import com.spring.security.service.RoleService;
import com.spring.security.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
public class RestAdminController {
    private final UserService userService;
    private final RoleService roleService;

    public RestAdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> showAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> showCreateUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return ResponseEntity.ok("Пользвоатель сохранен");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        try {
            userService.updateUser(id, user);
            return ResponseEntity.ok("Пользвоатель изменен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Невозможно изменить пользователя");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        try {
            userService.removeUser(id);
            return ResponseEntity.ok(String.valueOf(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Нельзя удалить пользователя");
        }
    }
    @GetMapping("/roles")
    public ResponseEntity<List<Role>> showAllRoles() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }
}
