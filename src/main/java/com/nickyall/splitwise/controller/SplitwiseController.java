package com.nickyall.splitwise.controller;

import com.nickyall.splitwise.model.Expense;
import com.nickyall.splitwise.model.Group;
import com.nickyall.splitwise.model.Role;
import com.nickyall.splitwise.model.User;
import com.nickyall.splitwise.requests.AddUsersToGroupRequest;
import com.nickyall.splitwise.requests.CreateExpenseRequest;
import com.nickyall.splitwise.requests.CreateGroupRequest;
import com.nickyall.splitwise.requests.DeleteUserFromGroupRequest;
import com.nickyall.splitwise.response.GroupsResponse;
import com.nickyall.splitwise.service.ExpenseService;
import com.nickyall.splitwise.service.GroupService;
import com.nickyall.splitwise.service.RoleService;
import com.nickyall.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/user/{userId}/groups")
    public List<GroupsResponse> getUserGroups(@PathVariable String userId) {
        return groupService.getUserGroups(userId);
    }

    @GetMapping(value = "/group/{groupId}/users")
    public List<User> getGroupUsers(@PathVariable String groupId) {
        return groupService.getGroupUsers(groupId);
    }

    @GetMapping(value = "/user/{userId}/expenses")
    public List<Expense> getUserExpenses(@PathVariable String userId) {
        return expenseService.getUserExpenses(userId);
    }

    @GetMapping(value = "/groups/{groupId}/expenses")
    public List<Expense> getGroupExpenses(@PathVariable String groupId) {
        return expenseService.getGroupExpenses(groupId);
    }

    @PostMapping(value = "/groups/{groupId}/addUsers")
    public void addUsersToGroup(@RequestBody AddUsersToGroupRequest addUsersToGroupRequest) {
        groupService.addUsersToGroup(addUsersToGroupRequest);
    }

    @DeleteMapping(value = "/group/{groupId}/delete")
    public void deleteGroup(@PathVariable String groupId) {
        groupService.deleteGroup(groupId);
    }

    @PostMapping(value = "/group/deleteUser")
    public void deleteUserFromGroup(@RequestBody DeleteUserFromGroupRequest deleteUserFromGroupRequest) {
        groupService.deleteUserFromGroup(deleteUserFromGroupRequest);
    }

    @DeleteMapping(value = "/expenses/{expenseId}/delete")
    public void deleteExpense(@PathVariable String expenseId) {
        expenseService.deleteExpense(expenseId);
    }
}
