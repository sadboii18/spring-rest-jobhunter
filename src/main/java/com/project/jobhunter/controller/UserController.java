package com.project.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.jobhunter.domain.User;
import com.project.jobhunter.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/create")
    public String getCreateUserPage() {
        User user = new User();
        user.setName("ducdo");
        user.setEmail("123@gmail.com");
        user.setPassword("!23");
        this.userService.handleCreateNewUser(user);
        return "new User";
    }

}
