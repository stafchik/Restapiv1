package com.spring.security.service;


import com.spring.security.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByUsername(String username);

    void addUser(User user);

    void updateUser(long id, User updatedUser);

    void removeUser(Long id);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
