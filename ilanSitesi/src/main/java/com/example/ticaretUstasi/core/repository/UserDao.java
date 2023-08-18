package com.example.ticaretUstasi.core.repository;

import com.example.ticaretUstasi.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
}
