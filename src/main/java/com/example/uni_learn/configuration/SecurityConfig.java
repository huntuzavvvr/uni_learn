package com.example.uni_learn.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private CustomUserDetailsService customUserDetailsService;
    private JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService, JwtAuthFilter jwtAuthFilter){
        this.customUserDetailsService = customUserDetailsService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth.requestMatchers(
            "/register", 
            "/login", 
            "/swagger-ui.html", 
            "/swagger-ui/**",  
            "/v3/api-docs/**",
            "/v3/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/v2/api-docs",
            "/configuration/security",
            "/webjars/**"
            ).permitAll()
        .requestMatchers(HttpMethod.POST, "/categories/**").hasRole("ADMIN")
        .requestMatchers(HttpMethod.DELETE, "/categories/**").hasRole("ADMIN")
        .requestMatchers(HttpMethod.PUT, "/categories/**").hasRole("ADMIN")
        .requestMatchers(HttpMethod.POST, "/courses/**").hasRole("ADMIN")
        .requestMatchers(HttpMethod.DELETE, "/courses/**").hasRole("ADMIN")
        .requestMatchers(HttpMethod.PUT, "/courses/**").hasRole("ADMIN")
        .requestMatchers(HttpMethod.POST, "/lectures/**").hasRole("ADMIN")
        .requestMatchers(HttpMethod.DELETE, "/lectures/**").hasRole("ADMIN")
        .requestMatchers(HttpMethod.PUT, "/lectures/**").hasRole("ADMIN")
        .anyRequest().authenticated())
        // .httpBasic(Customizer.withDefaults())
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
        .userDetailsService(customUserDetailsService)
        .and()
        .build();
    }
}
