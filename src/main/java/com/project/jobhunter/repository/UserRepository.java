package com.project.jobhunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.jobhunter.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
