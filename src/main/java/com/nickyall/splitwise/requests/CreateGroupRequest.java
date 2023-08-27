package com.nickyall.splitwise.requests;

import java.util.List;

public class CreateGroupRequest {
    private String name;
    private List<String> memberIds;

    public String getName() {
        return name;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }
}
