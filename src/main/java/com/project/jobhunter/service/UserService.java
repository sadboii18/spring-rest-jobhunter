package com.project.jobhunter.service;

import org.springframework.stereotype.Service;

import com.project.jobhunter.domain.User;
import com.project.jobhunter.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateNewUser(User user) {
        return this.userRepository.save(user);
    }

}
