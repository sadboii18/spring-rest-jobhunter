package com.project.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.jobhunter.domain.User;
import com.project.jobhunter.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping("/user/create")
    @PostMapping("/user/create")
    public User getCreateUserPage(@RequestBody User user) {
        User newUser = this.userService.handleCreateNewUser(user);
        return newUser;
    }

}
