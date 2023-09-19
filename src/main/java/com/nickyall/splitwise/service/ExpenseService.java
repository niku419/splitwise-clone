package com.nickyall.splitwise.service;

import com.nickyall.splitwise.model.Expense;
import com.nickyall.splitwise.model.Group;
import com.nickyall.splitwise.model.User;
import com.nickyall.splitwise.repository.ExpenseRepository;
import com.nickyall.splitwise.repository.GroupRepository;
import com.nickyall.splitwise.repository.UserRepository;
import com.nickyall.splitwise.requests.CreateExpenseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

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
        String originalEmail = expenseRequest.getPayerEmailId().replace(".", "_");
        final User payerUser = userRepository.findByEmailId(originalEmail);
        if (payerUser == null) {
            throw new UsernameNotFoundException("Payer not found");
        }
        HashMap<String, Double> participants = new HashMap<>();
        for (Map.Entry<String, Double> entry : expenseRequest.getParticipants().entrySet()) {
            String originalParticipantEmail = entry.getKey().replace(".", "_");
            final Double amount = entry.getValue();
            final User participant = userRepository.findByEmailId(originalParticipantEmail);
            if (participant != null) {
                participants.put(participant.getEmailId(), amount);
            }
        }
        expense.setPayerId(payerUser.getId());
        expense.setAmount(expenseRequest.getAmount());
        expense.setDescription(expenseRequest.getDescription());
        expense.setParticipants(participants);
        expense.setGroupId(expenseRequest.getGroupId());
        expenseRepository.save(expense);
        Optional<Group> group = groupRepository.findById(expenseRequest.getGroupId());
        for (final String participant: participants.keySet()) {
            String originalParticipantEmail = participant.replace(".", "_");
            User user = userRepository.findByEmailId(originalParticipantEmail);
            if (user != null) {
                List<String> expenses = user.getExpensesIds();
                if (expenses == null) {
                    expenses = new ArrayList<>();
                }
                expenses.add(expense.getId());
                user.setExpensesIds(expenses);
                userRepository.save(user);
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
