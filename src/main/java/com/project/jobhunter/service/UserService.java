package com.project.jobhunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.jobhunter.domain.User;
import com.project.jobhunter.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public Optional<User> handleFetchUserById(long id) {
        return this.userRepository.findById(id);
    }

    public List<User> handleFindAllUser() {
        return this.userRepository.findAll();
    }

}
