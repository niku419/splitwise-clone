package com.nickyall.splitwise.service;

import com.nickyall.splitwise.model.Expense;
import com.nickyall.splitwise.model.Group;
import com.nickyall.splitwise.model.User;
import com.nickyall.splitwise.repository.ExpenseRepository;
import com.nickyall.splitwise.repository.GroupRepository;
import com.nickyall.splitwise.repository.UserRepository;
import com.nickyall.splitwise.requests.CreateGroupRequest;
import com.nickyall.splitwise.response.GroupsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ExpenseRepository expenseRepository;

    public Group createGroup(final CreateGroupRequest groupRequest) {
        final Group group = new Group();
        groupRepository.save(group);
        List<String> memberIds = new ArrayList<>();
        if (groupRequest.getMemberEmailIds() != null) {
            for (final String emailId: groupRequest.getMemberEmailIds()) {
                final User user = userRepository.findByEmailId(emailId);
                if (user != null) {
                    final List<String> groupIds = user.getGroupIds();
                    memberIds.add(user.getEmailId());
                    groupIds.add(group.getId());
                    user.setGroupIds(groupIds);
                    userRepository.save(user);
                }
            }
        }
        group.setName(groupRequest.getName());
        group.setMemberIds(memberIds);
        group.setExpenses(new ArrayList<>());
        return groupRepository.save(group);
    }

    public List<GroupsResponse> getUserGroups(final String userId) {
        final Optional<User> optionalUser = userRepository.findById(userId);
        List<GroupsResponse> groupsResponses = new ArrayList<>();
        if (optionalUser.isPresent()) {
            final User user = optionalUser.get();
            List<String> userGroupIds = user.getGroupIds();
            if (userGroupIds.size() > 0) {
                GroupsResponse groupsResponse = new GroupsResponse();
                for (final String groupId:userGroupIds) {
                    if (groupId != null) {
                        final Optional<Group> group = groupRepository.findById(groupId);
                        if (group.isPresent()) {
                            List<User> users = new ArrayList<>();
                            for (final String member: group.get().getMemberIds()) {
                                final Optional<User> optionalMember = userRepository.findById(member);
                                if (optionalMember.isPresent()) {
                                    users.add(optionalUser.get());
                                }
                            }
                            List<Expense> expenses = new ArrayList<>();
                            for (final String expense:group.get().getExpenses()) {
                                final Optional<Expense> optionalExpense = expenseRepository.findById(expense);
                                optionalExpense.ifPresent(expenses::add);
                            }
                            groupsResponse.setExpenses(expenses);
                            groupsResponse.setUsers(users);
                            groupsResponse.setName(group.get().getName());
                            groupsResponse.setId(group.get().getId());
                        }
                    }
                }
                groupsResponses.add(groupsResponse);
            }
        }
        return groupsResponses;
    }

    public List<Group> findAll(){
        return groupRepository.findAll();
    }
    public void save(Group group) {
        groupRepository.save(group);
    }
}
