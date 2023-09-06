package com.nickyall.splitwise.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Document(collection = "expenses")
public class Expense {

    private String id;
    private String description;
    private String payerId;
    private double amount;
    private HashMap<String, Double> participants;
    private String groupId;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParticipants(HashMap<String, Double> participants) {
        this.participants = participants;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getPayerId() {
        return payerId;
    }

    public HashMap<String, Double> getParticipants() {
        return participants;
    }

    public String getId() {
        return id;
    }

    public String getGroupId() {
        return groupId;
    }
}
