package com.nickyall.splitwise.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getPayerId() {
        return payerId;
    }

    public List<String> getParticipantIds() {
        return participantIds;
    }
}
