package com.example.uni_learn.configuration;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private String Secret = "supersecretsupersecretsupersecretsupersecret";
    private int expiration = 1000 * 60 * 60;
    private Key key = Keys.hmacShaKeyFor(Secret.getBytes());

    public String generateToken(String username){
        return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + expiration))
        .signWith(key)
        .compact();
    }

    public String extractUsername(String token){
        return Jwts.parserBuilder()
        .setSigningKey(key)
        .build()
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }
        catch (JwtException ex){
            return false;
        }
    }
}
