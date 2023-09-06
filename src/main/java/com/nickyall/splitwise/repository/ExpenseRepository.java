package com.nickyall.splitwise.repository;

import com.nickyall.splitwise.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    public Expense findByPayerId(String payerId);
    //    public List<Expense> find
}
