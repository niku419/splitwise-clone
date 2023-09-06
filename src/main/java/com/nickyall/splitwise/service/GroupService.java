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
        group.setName(groupRequest.getName());
        group.setMemberIds(groupRequest.getMemberIds());
        group.setExpenses(groupRequest.getExpenses());
        groupRepository.save(group);
        if (group.getMemberIds() != null) {
            for (final String userId: group.getMemberIds()) {
                final Optional<User> user = userRepository.findById(userId);
                if (user.isPresent()) {
                    final List<String> groupIds = user.get().getGroupIds();
                    groupIds.add(group.getId());
                    user.get().setGroupIds(groupIds);
                    userRepository.save(user.get());
                }
            }
        }
        return groupRepository.save(group);
    }

    public List<GroupsResponse> getUserGroups(final String userId) {
        final Optional<User> optionalUser = userRepository.findById(userId);
        List<GroupsResponse> groupsResponses = new ArrayList<>();
        List<Group> groups = new ArrayList<>();
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
}
