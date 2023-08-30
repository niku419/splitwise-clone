package com.nickyall.splitwise.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.nickyall.splitwise.model.Role;
import com.nickyall.splitwise.model.ERole;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
