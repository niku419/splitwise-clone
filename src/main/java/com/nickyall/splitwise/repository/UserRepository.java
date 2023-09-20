package com.nickyall.splitwise.repository;

import com.nickyall.splitwise.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByEmailId(String emailId);

    Boolean existsByEmailId(String emailId);

    @Query("{ 'emailId' : { $eq : ?0 } }")
    Optional<User> findByEmailIdExact(String emailId);
}
