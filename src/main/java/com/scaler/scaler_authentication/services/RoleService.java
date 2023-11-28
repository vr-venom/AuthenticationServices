package com.scaler.scaler_authentication.services;

import com.scaler.scaler_authentication.model.Role;
import com.scaler.scaler_authentication.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(String name) {
        Role role = new Role();
//        role.setRole(name);

        return roleRepository.save(role);
    }
}

