package com.nickyall.splitwise.service;

import com.nickyall.splitwise.model.User;
import com.nickyall.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User createUser(final User user) {
        return userRepository.save(user);
    }
}
