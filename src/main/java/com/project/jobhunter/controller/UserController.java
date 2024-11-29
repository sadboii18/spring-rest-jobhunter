package com.project.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.jobhunter.domain.User;
import com.project.jobhunter.service.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping("/user/create")
    @PostMapping("/user/create")
    public User getCreateUserPage(@RequestBody User user) {
        User newUser = this.userService.handleCreateUser(user);
        return newUser;
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
        return "delete success";
    }

    @GetMapping("/user/fetch/{id}")
    public User fetchUserById(@PathVariable("id") long id) {
        User user = this.userService.handleFetchUserById(id);
        return user;
    }

    @GetMapping("/user/fetchAll")
    public List<User> fetchAllUser() {
        List<User> userList = new ArrayList<>();
        userList = this.userService.handleFindAllUser();
        return userList;
    }

    @PutMapping("/user/update")
    public User updateUser(@RequestBody User user) {
        User updateUser = this.userService.handleUpdateUser(user);
        return updateUser;
    }

}
