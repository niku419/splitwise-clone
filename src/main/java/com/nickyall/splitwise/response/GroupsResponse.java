package com.nickyall.splitwise.response;

import com.nickyall.splitwise.model.Expense;
import com.nickyall.splitwise.model.User;

import java.util.List;

public class GroupsResponse {
    private String name;
    private List<User> users;
    private List<Expense> expenses;

    public List<Expense> getExpenses() {
        return expenses;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
