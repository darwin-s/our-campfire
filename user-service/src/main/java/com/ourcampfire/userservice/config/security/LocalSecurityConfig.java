package com.ourcampfire.userservice.config.security;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;

import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * Security configuration for the local profile
 */
@Configuration
@Profile("mockjwt")
@ConfigurationProperties(prefix = "mock.jwt")
@Setter
public class LocalSecurityConfig {

    private String sub;
    private String username;
    private List<String> roles;

    @Bean
    public JwtDecoder mockJwtDecoder() {
        return token ->
                new Jwt(
                        token,
                        Instant.now(),
                        Instant.now().plusSeconds(36000),
                        Map.of("alg", "none"),
                        Map.of(
                                "sub", sub,
                                "preferred_username", username,
                                "realm_access", Map.of("roles", roles)
                        )
                );
    }
}
