package com.nickyall.splitwise.requests;

public class DeleteUserFromGroupRequest {
    private String groupId;
    private String userId;

    public String getGroupId() {
        return groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
