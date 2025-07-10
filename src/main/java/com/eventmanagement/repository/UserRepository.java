package com.eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventmanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}