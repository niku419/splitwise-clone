package com.nickyall.splitwise.repository;

import com.nickyall.splitwise.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByEmailId(String emailId);

    Boolean existsByEmailId(String emailId);

}
