package com.spring.security.service;

import com.spring.security.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    void addRole(Role role);

    Role getRoleById(Long id);


    public void save(List<Role> roles);

}
