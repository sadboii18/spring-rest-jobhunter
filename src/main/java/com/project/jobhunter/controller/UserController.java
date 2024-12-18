package com.project.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.jobhunter.domain.User;
import com.project.jobhunter.service.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping("/users/create")
    @PostMapping("/users")
    public ResponseEntity<User> getCreateUserPage(@RequestBody User user) {
        User newUser = this.userService.handleCreateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> fetchUserById(@PathVariable("id") long id) {
        User user = this.userService.handleFetchUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> fetchAllUser() {
        List<User> userList = new ArrayList<>();
        userList = this.userService.handleFindAllUser();
        return ResponseEntity.ok(userList);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = this.userService.handleUpdateUser(user);
        return ResponseEntity.ok(updateUser);
    }

}
