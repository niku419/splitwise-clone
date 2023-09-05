package com.nickyall.splitwise.requests;

import com.nickyall.splitwise.model.User;

import java.util.HashMap;

public class CreateExpenseRequest {
    private String id;
    private String description;
    private String payerId;
    private double amount;
    private HashMap<User, Double> participants;

    public HashMap<User, Double> getParticipants() {
        return participants;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getPayerId() {
        return payerId;
    }

    public String getId() {
        return id;
    }
}
