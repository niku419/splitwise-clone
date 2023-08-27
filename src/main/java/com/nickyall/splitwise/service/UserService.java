package com.nickyall.splitwise.service;

import com.nickyall.splitwise.model.User;
import com.nickyall.splitwise.repository.UserRepository;
import com.nickyall.splitwise.requests.CreateUserRequest;
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

    public User createUser(final CreateUserRequest userRequest) {
        final User user = new User();
        user.setEmailId(userRequest.getEmailId());
        user.setName(userRequest.getName());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        return userRepository.save(user);
    }
}
