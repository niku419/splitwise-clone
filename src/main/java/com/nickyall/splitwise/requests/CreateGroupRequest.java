package com.nickyall.splitwise.requests;

import java.util.List;

public class CreateGroupRequest {
    private String id;
    private String name;
    private List<String> memberIds;
    private List<String> expenses;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<String> getExpenses() {
        return expenses;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }

    public String getId() {
        return id;
    }
}
