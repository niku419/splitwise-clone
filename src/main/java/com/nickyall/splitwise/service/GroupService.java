package com.nickyall.splitwise.service;

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
public class GroupService {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    UserRepository userRepository;

    public Group createGroup(final CreateGroupRequest groupRequest) {
        final Group group = new Group();
        group.setName(groupRequest.getName());
        group.setMemberIds(groupRequest.getMemberIds());
        group.setExpenses(groupRequest.getExpenses());
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

    public List<Group> getUserGroups(final String userId) {
        final Optional<User> optionalUser = userRepository.findById(userId);
        List<Group> groups = new ArrayList<>();
        if (optionalUser.isPresent()) {
            final User user = optionalUser.get();
            List<String> userGroupIds = user.getGroupIds();
            if (userGroupIds.size() > 0) {
                for (final String groupId:userGroupIds) {
                    final Optional<Group> group = groupRepository.findById(groupId);
                    group.ifPresent(groups::add);
                }
            }
        }
        return groups;
    }

    public List<Group> findAll(){
        return groupRepository.findAll();
    }
}
