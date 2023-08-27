package com.nickyall.splitwise.controller;


import com.nickyall.splitwise.model.Expense;
import com.nickyall.splitwise.model.Group;
import com.nickyall.splitwise.model.User;
import com.nickyall.splitwise.requests.CreateExpenseRequest;
import com.nickyall.splitwise.requests.CreateGroupRequest;
import com.nickyall.splitwise.requests.CreateUserRequest;
import com.nickyall.splitwise.service.ExpenseService;
import com.nickyall.splitwise.service.GroupService;
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
    @Autowired
    GroupService groupService;

    @GetMapping(value = "/")
    public String home() {
        return "Welcome to Splitwise";
    }

    @GetMapping(value = "/getUsers")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/getExpenses")
    public List<Expense> getExpenses() {
        return expenseService.findAll();
    }

    @GetMapping(value = "/getGroups")
    public List<Group> getGroups() {
        return groupService.findAll();
    }

    @PostMapping(value = "/createUser")
    public User createUser(@RequestBody CreateUserRequest user) {
        User user1 = userService.createUser(user);
        System.out.println("sonkjdn" + user1);
        return user1;
    }

    @PostMapping(value = "/createExpense")
    public Expense createExpense(@RequestBody CreateExpenseRequest expense) {
        return expenseService.createExpense(expense);
    }

    @PostMapping(value = "/createGroup")
    public Group createGroup(@RequestBody CreateGroupRequest group) {
        return groupService.createGroup(group);
    }

}
