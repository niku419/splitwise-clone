package com.nickyall.splitwise.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "users")
public class User {

    @Id
    private String id;
    @NotBlank
    @Size(max = 20)
    @Email
    private String emailId;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    @Size(max = 20)
    private String name;
    @NotBlank
    @Size(max = 50)
    private String password;
    @DBRef
    private Set<Role> roles = new HashSet<>();
    private List<String> groupIds;
    private List<String> expensesIds;

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
    public String getPassword() {
        return password;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public List<String> getGroupIds() {
        return groupIds;
    }

    public List<String> getExpensesIds() {
        return expensesIds;
    }

    public void setGroupIds(List<String> groupIds) {
        this.groupIds = groupIds;
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
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setExpensesIds(List<String> expensesIds) {
        this.expensesIds = expensesIds;
    }
}
