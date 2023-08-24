package com.nickyall.splitwise.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String emailId;
    private String phoneNumber;
    private String name;

    public String getId() {
        return id;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
