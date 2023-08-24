package com.nickyall.splitwise.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "expenses")
public class Expense {

    @Id
    private String id;
    private String description;
    private String payerId;
    private double amount;
    private List<String> participantIds;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParticipantIds(List<String> participantIds) {
        this.participantIds = participantIds;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

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
