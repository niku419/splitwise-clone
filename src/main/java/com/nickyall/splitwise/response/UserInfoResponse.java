package com.nickyall.splitwise.response;

import java.util.List;

public class UserInfoResponse {
    private String id;
    private String email;
    private List<String> roles;

    public UserInfoResponse(String id, String email, List<String> roles) {
        this.id = id;
        this.email = email;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }
}