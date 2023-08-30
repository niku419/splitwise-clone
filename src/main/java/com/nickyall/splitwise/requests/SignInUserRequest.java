package com.nickyall.splitwise.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class SignInUserRequest {
    @Email
    @NotBlank
    private String emailId;

    @NotBlank
    private String password;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
