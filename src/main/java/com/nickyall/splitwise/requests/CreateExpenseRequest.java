package com.nickyall.splitwise.requests;

import java.util.HashMap;

public class CreateExpenseRequest {
    private String description;
    private String payerEmailId;
    private double amount;
    private HashMap<String, Double> participants;
    private String groupId;

    public HashMap<String, Double> getParticipants() {
        return participants;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getPayerEmailId() {
        return payerEmailId;
    }

    public String getGroupId() {
        return groupId;
    }
}
