package com.nickyall.splitwise.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Document(collection = "groups")
public class Group {
    @Id
    private String id;
    private String name;
    private List<String> memberIds;
    private List<Expense> expenses;

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberIds(List<String> memberIds) {
        this.memberIds = memberIds;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public String getId() {
        return id;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }

    public String getName() {
        return name;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
