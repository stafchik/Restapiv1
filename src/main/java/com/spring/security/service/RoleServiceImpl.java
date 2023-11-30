package com.spring.security.service;


import com.spring.security.model.Role;
import com.spring.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getById(id);
    }

    @Transactional
    @Override
    public void save(List<Role> roles) {
        roleRepository.saveAll(roles);
    }
}
