package com.nickyall.splitwise.controller;


import com.nickyall.splitwise.model.Expense;
import com.nickyall.splitwise.model.User;
import com.nickyall.splitwise.service.ExpenseService;
import com.nickyall.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SplitwiseController {

    @Autowired
    UserService userService;
    @Autowired
    ExpenseService expenseService;

    @GetMapping(value = "/")
    public String home() {
        return "Welcome to Splitwise hi";
    }

    @GetMapping(value = "/getUsers")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping(value = "/createUser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping(value = "/createExpense")
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }

    @GetMapping(value = "/getExpenses")
    public List<Expense> getExpenses() {
        return expenseService.findAll();
    }
}
