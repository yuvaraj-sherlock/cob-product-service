package com.cob.product.config;

import com.lib.token.cob.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    private final String JWT_SECRET = System.getenv("JWT_SECRET");

    @Bean
    public JwtUtil jwtUtil(){
        if (JWT_SECRET == null || JWT_SECRET.isEmpty()) {
            throw new RuntimeException("Missing required environment variable: JWT_SECRET");
        }
        return new JwtUtil(JWT_SECRET, 3600000L); // 1 hour expiry in milliseconds(SECRET_KEY);
    }
}
