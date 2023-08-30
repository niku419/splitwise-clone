package com.nickyall.splitwise.controller;


import com.nickyall.splitwise.model.Expense;
import com.nickyall.splitwise.model.Group;
import com.nickyall.splitwise.model.Role;
import com.nickyall.splitwise.model.User;
import com.nickyall.splitwise.requests.CreateExpenseRequest;
import com.nickyall.splitwise.requests.CreateGroupRequest;
import com.nickyall.splitwise.requests.CreateUserRequest;
import com.nickyall.splitwise.service.ExpenseService;
import com.nickyall.splitwise.service.GroupService;
import com.nickyall.splitwise.service.RoleService;
import com.nickyall.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/splitwise")
public class SplitwiseController {

    @Autowired
    UserService userService;
    @Autowired
    ExpenseService expenseService;
    @Autowired
    GroupService groupService;
    @Autowired
    RoleService roleService;

    @GetMapping(value = "/")
    public String home() {
        return "Welcome to Splitwise";
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
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
        return userService.createUser(user);
    }

    @PostMapping(value = "/createExpense")
    public Expense createExpense(@RequestBody CreateExpenseRequest expense) {
        return expenseService.createExpense(expense);
    }

    @PostMapping(value = "/createGroup")
    public Group createGroup(@RequestBody CreateGroupRequest group) {
        return groupService.createGroup(group);
    }

    @PostMapping(value = "/createRole")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @GetMapping(value = "/getRoles")
    public List<Role> getRoles() {
        return roleService.findAll();
    }
}
