package com.cob.product.config;

import com.lib.token.cob.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    private String JWT_SECRET = System.getenv("JWT_SECRET");

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil(JWT_SECRET);
    }
}
