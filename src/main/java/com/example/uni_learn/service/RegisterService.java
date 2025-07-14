package com.example.uni_learn.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.uni_learn.Repository.UserRepository;
import com.example.uni_learn.model.User;

@Service
public class RegisterService {

    private UserRepository userRepository;

    public RegisterService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> register(User user){
        if (userRepository.existsByUsername(user.getUsername())){
            return ResponseEntity.status(409).build();
        }
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());
        userRepository.save(u);
        return ResponseEntity.ok().build();
    }
}
