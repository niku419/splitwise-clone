package com.nickyall.splitwise.service;

import com.nickyall.splitwise.model.User;
import com.nickyall.splitwise.repository.UserRepository;
import com.nickyall.splitwise.requests.CreateGroupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupService groupService;

    private static final String NON_GROUP_EXPENSES_GROUP_NAME = "Non group Expneses";

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void createUser(final User user) {
        CreateGroupRequest groupRequest = new CreateGroupRequest();
        groupRequest.setName(NON_GROUP_EXPENSES_GROUP_NAME);
        groupRequest.setId(user.getId());
        groupService.createGroup(groupRequest);
        List<String> groupIds = new ArrayList<>();
        userRepository.save(user);
        groupIds.add(user.getId());
        user.setGroupIds(groupIds);
        userRepository.save(user);
    }

    public boolean existsByEmailId(String emailId) {
        return userRepository.existsByEmailId(emailId);
    }
}
