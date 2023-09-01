package com.nickyall.splitwise.service;

import com.nickyall.splitwise.model.ERole;
import com.nickyall.splitwise.model.Role;
import com.nickyall.splitwise.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role createRole(final Role role) {
        return roleRepository.save(role);
    }
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
    public Optional<Role> findByName(ERole role) {
        return roleRepository.findByName(role);
    }
}
