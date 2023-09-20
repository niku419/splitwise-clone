package com.nickyall.splitwise.service;

import com.nickyall.splitwise.model.Group;
import com.nickyall.splitwise.model.User;
import com.nickyall.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Group group = new Group();
        List<String> memberIds = new ArrayList<>();
        List<String> groupIds = new ArrayList<>();
        userRepository.save(user);
        memberIds.add(user.getId());
        group.setName(NON_GROUP_EXPENSES_GROUP_NAME);
        group.setMemberIds(memberIds);
        group.setExpenses(new ArrayList<>());
        groupService.save(group);
        groupIds.add(group.getId());
        user.setGroupIds(groupIds);
        userRepository.save(user);
    }

    public boolean existsByEmailId(String emailId) {
        return userRepository.existsByEmailId(emailId);
    }

    public Optional<User> findByEmailId(String emailId) {
        return userRepository.findByEmailIdExact(emailId);
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
