package com.nickyall.splitwise.service;

import com.nickyall.splitwise.model.Expense;
import com.nickyall.splitwise.repository.ExpenseRepository;
import com.nickyall.splitwise.requests.CreateExpenseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public Expense createExpense(final CreateExpenseRequest expenseRequest) {
        final Expense expense = new Expense();
        expense.setPayerId(expenseRequest.getPayerId());
        expense.setAmount(expenseRequest.getAmount());
        expense.setDescription(expenseRequest.getDescription());
        expense.setParticipants(expenseRequest.getParticipants());
        expense.setId(expenseRequest.getId());
        return expenseRepository.save(expense);
    }

    public List<Expense> findAll(){
        return expenseRepository.findAll();
    }
}
