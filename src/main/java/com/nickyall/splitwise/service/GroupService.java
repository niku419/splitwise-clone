package com.nickyall.splitwise.service;

import com.nickyall.splitwise.model.Group;
import com.nickyall.splitwise.repository.GroupRepository;
import com.nickyall.splitwise.requests.CreateGroupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    public Group createGroup(final CreateGroupRequest groupRequest) {
        final Group group = new Group();
        group.setName(groupRequest.getName());
        group.setMemberIds(groupRequest.getMemberIds());
        return groupRepository.save(group);
    }

    public List<Group> findAll(){
        return groupRepository.findAll();
    }
}
