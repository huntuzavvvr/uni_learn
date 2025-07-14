package com.example.uni_learn.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.uni_learn.Repository.UserRepository;
import com.example.uni_learn.configuration.JwtUtil;
import com.example.uni_learn.dto.LoginDto;
import com.example.uni_learn.model.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

class AuthorizationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private AuthorizationService authorizationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnOkWhenCredentialsAreValid() {
        LoginDto loginDto = new LoginDto("admin", "1234");
        User user = new User();
        user.setUsername("admin");
        user.setPassword("1234");
        user.setRole("ROLE_ADMIN");

        when(userRepository.findByUsername("admin")).thenReturn(user);
        when(jwtUtil.generateToken("admin")).thenReturn("mocked-jwt-token");

        ResponseEntity<?> response = authorizationService.login(loginDto);

        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void shouldReturn401WhenPasswordIsIncorrect() {
        LoginDto loginDto = new LoginDto("admin", "wrongpassword");
        User user = new User();
        user.setUsername("admin");
        user.setPassword("correctpassword");

        when(userRepository.findByUsername("admin")).thenReturn(user);

        ResponseEntity<?> response = authorizationService.login(loginDto);

        assertEquals(401, response.getStatusCode().value());
    }

    @Test
    void shouldReturn401WhenUserDoesNotExist() {
        LoginDto loginDto = new LoginDto("nonexistent", "any");

        when(userRepository.findByUsername("nonexistent")).thenReturn(null);

        ResponseEntity<?> response = authorizationService.login(loginDto);

        assertEquals(401, response.getStatusCode().value());
    }
}
