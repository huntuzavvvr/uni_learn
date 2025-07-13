package com.example.uni_learn.service;

import java.net.ResponseCache;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.uni_learn.Repository.UserRepository;
import com.example.uni_learn.model.User;

@Service
public class AuthorizationService {
    private UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> login(User user){
        if (user.getPassword().equals(userRepository.findByUsername(user.getUsername()).getPassword())){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(401).build();
    }
}
