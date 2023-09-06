package com.nickyall.splitwise.service;

import com.nickyall.splitwise.model.Expense;
import com.nickyall.splitwise.model.Group;
import com.nickyall.splitwise.model.User;
import com.nickyall.splitwise.repository.ExpenseRepository;
import com.nickyall.splitwise.repository.GroupRepository;
import com.nickyall.splitwise.repository.UserRepository;
import com.nickyall.splitwise.requests.CreateExpenseRequest;
import com.nickyall.splitwise.response.GroupsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    public Expense createExpense(final CreateExpenseRequest expenseRequest) {
        final Expense expense = new Expense();
        expense.setPayerId(expenseRequest.getPayerId());
        expense.setAmount(expenseRequest.getAmount());
        expense.setDescription(expenseRequest.getDescription());
        expense.setParticipants(expenseRequest.getParticipants());
        expense.setGroupId(expenseRequest.getGroupId());
        expenseRepository.save(expense);
        Optional<Group> group = groupRepository.findById(expenseRequest.getGroupId());
        for (final String participant: expenseRequest.getParticipants().keySet()) {
            Optional<User> optionalUser = userRepository.findById(participant);
            if (optionalUser.isPresent()) {
                List<String> expenses = optionalUser.get().getExpensesIds();
                if (expenses == null) {
                    expenses = new ArrayList<>();
                }
                expenses.add(expense.getId());
                userRepository.save(optionalUser.get());
            }
        }
        if (group.isPresent()) {
            List<String> expenses = group.get().getExpenses();
            if (expenses == null) {
                expenses = new ArrayList<>();
            }
            expenses.add(expense.getId());
            groupRepository.save(group.get());
        }
        return expense;
    }

    public List<Expense> getUserExpenses(final String userId) {
        final Optional<User> optionalUser = userRepository.findById(userId);
        List<Expense> expenses = new ArrayList<>();
        if (optionalUser.isPresent()) {
            List<String> expenseIds = optionalUser.get().getExpensesIds();
            if (expenseIds != null) {
                for (final String expenseId: expenseIds) {
                    Optional<Expense> expense = expenseRepository.findById(expenseId);
                    expenses.add(expense.get());
                }
            }
        }
        return expenses;
    }

    public List<Expense> findAll(){
        return expenseRepository.findAll();
    }
}
