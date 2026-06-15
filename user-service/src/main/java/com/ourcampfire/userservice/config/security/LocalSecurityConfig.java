package com.ourcampfire.userservice.config.security;

import org.springframework.beans.factory.annotation.Value;
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
public class LocalSecurityConfig {

    @Value("${mock.jwt.sub:admin}")
    private String mockSub;

    @Value("${mock.jwt.username:admin}")
    private String mockUsername;

    @Value("${mock.jwt.roles:}")
    private List<String> mockRoles;

    @Bean
    public JwtDecoder mockJwtDecoder() {
        return token ->
                new Jwt(
                        token,
                        Instant.now(),
                        Instant.now().plusSeconds(36000),
                        Map.of("alg", "none"),
                        Map.of(
                                "sub", mockSub,
                                "preferred_username", mockUsername,
                                "realm_access", Map.of("roles", mockRoles)
                        )
                );
    }
}
