package com.ayush.MyFitnessPal.service;

import com.ayush.MyFitnessPal.model.User;
import com.ayush.MyFitnessPal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    //sign up
    public User registerUser(User user){
        if(user.getEmail() == null || user.getEmail().isEmpty()){
            throw new RuntimeException("Email cannot be empty");
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()){
            throw new RuntimeException("Password cannot be empty");
        }
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if(existing.isPresent()){
            throw new RuntimeException("User already registered.");
        }
        return userRepository.save(user);
    }

    //login
    public User loginUser(String email, String password){
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isEmpty()){
            throw new RuntimeException("Email not found.");
        }
        if(email == null || password == null) {
            throw new RuntimeException("Email or password missing");
        }
        if(!user.get().getPassword().equals(password)){
            throw new RuntimeException("Incorrect password.");
        }

        return user.get();
    }

    public User findById(String userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found."));

    }
}
