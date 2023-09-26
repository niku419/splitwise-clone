package com.nickyall.splitwise.requests;

import java.util.List;

public class AddUsersToGroupRequest {

    private String groupId;
    private List<String> memberEmailIds;

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setMemberEmailIds(List<String> memberEmailIds) {
        this.memberEmailIds = memberEmailIds;
    }

    public String getGroupId() {
        return groupId;
    }

    public List<String> getMemberEmailIds() {
        return memberEmailIds;
    }
}
