package com.nickyall.splitwise.requests;

import java.util.List;

public class CreateExpenseRequest {
    private String description;
    private String payerId;
    private double amount;
    private List<String> participantIds;

    public List<String> getParticipantIds() {
        return participantIds;
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
}
