package com.example.uni_learn.configuration;

import org.hibernate.annotations.Comment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.example.uni_learn.Repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username){
        return new CustomUserDetails(userRepository.findByUsername(username));
    }
}
