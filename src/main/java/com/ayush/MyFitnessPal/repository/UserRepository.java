package com.ayush.MyFitnessPal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayush.MyFitnessPal.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    // 🔍 Find user by email (used for login)
    Optional<User> findByEmail(String email);
}