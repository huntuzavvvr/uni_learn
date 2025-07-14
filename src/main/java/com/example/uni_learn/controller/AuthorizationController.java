package com.example.uni_learn.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.uni_learn.dto.LoginDto;
import com.example.uni_learn.exception.ApiError;
import com.example.uni_learn.model.User;
import com.example.uni_learn.service.AuthorizationService;
import com.example.uni_learn.service.RegisterService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AuthorizationController {

    private RegisterService registerService;
    private AuthorizationService authorizationService;

    public AuthorizationController(RegisterService registerService, AuthorizationService authorizationService){
        this.registerService = registerService;
        this.authorizationService = authorizationService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return registerService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto user) {

        return authorizationService.login(user);
    }
    
    
}
