package com.nickyall.splitwise.service;

import com.nickyall.splitwise.model.Expense;
import com.nickyall.splitwise.model.Group;
import com.nickyall.splitwise.model.User;
import com.nickyall.splitwise.repository.GroupRepository;
import com.nickyall.splitwise.repository.UserRepository;
import com.nickyall.splitwise.requests.CreateGroupRequest;
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
    private GroupRepository groupRepository;
    @Autowired
    private GroupService groupService;
    @Autowired
    private ExpenseService expenseService;

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
        groupRepository.save(group);
        groupIds.add(group.getId());
        user.setGroupIds(groupIds);
        userRepository.save(user);
    }

    public boolean existsByEmailId(String emailId) {
        return userRepository.existsByEmailId(emailId);
    }
}
