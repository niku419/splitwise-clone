package com.nickyall.splitwise.requests;

public class CreateUserRequest {
    private String emailId;
    private String phoneNumber;
    private String name;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }
}
