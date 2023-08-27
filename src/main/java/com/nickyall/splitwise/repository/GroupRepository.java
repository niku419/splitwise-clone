package com.nickyall.splitwise.repository;

import com.nickyall.splitwise.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {
}
