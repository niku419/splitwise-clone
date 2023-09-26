package com.nickyall.splitwise.response;

import java.util.List;

public class UserInfoResponse {
    private String id;
    private String email;
    private String phoneNumber;
    private String name;
    private List<String> roles;
    private String token;

    public UserInfoResponse(String id, String email, String phoneNumber, String name, List<String> roles, String token) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.token = token;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }
}