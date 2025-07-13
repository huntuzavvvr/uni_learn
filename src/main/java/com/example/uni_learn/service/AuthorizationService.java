package com.example.uni_learn.service;

import java.net.ResponseCache;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.uni_learn.Repository.UserRepository;
import com.example.uni_learn.configuration.JwtUtil;
import com.example.uni_learn.dto.LoginDto;
import com.example.uni_learn.model.User;

@Service
public class AuthorizationService {
    private UserRepository userRepository;
    private JwtUtil jwtUtil;

    public AuthorizationService(UserRepository userRepository, JwtUtil jwtUtil){
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public ResponseEntity<?> login(LoginDto user){
        if (user.getPassword().equals(userRepository.findByUsername(user.getUsername()).getPassword())){
            System.out.print(jwtUtil.generateToken(user.getUsername()));
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(401).build();
    }
}
