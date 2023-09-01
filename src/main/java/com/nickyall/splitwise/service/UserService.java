package com.nickyall.splitwise.service;

import com.nickyall.splitwise.model.User;
import com.nickyall.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void createUser(final User user) {
        userRepository.save(user);
    }

    public boolean existsByEmailId(String emailId) {
        return userRepository.existsByEmailId(emailId);
    }
}
