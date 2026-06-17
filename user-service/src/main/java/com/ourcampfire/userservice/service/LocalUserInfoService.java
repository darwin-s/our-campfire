package com.ourcampfire.userservice.service;

import com.ourcampfire.userservice.dto.UserDto;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

/**
 * User info service for local runs (without an auth provider)
 */
@Service
@Profile("mockusers")
@ConfigurationProperties(prefix = "mock")
@Setter
public class LocalUserInfoService implements UserInfoService {
    private Map<String, UserDto> mockUsers;

    /**
     * Get information about a user
     *
     * @param id The id of the user
     * @return User information DTO if it exists
     */
    @Override
    public Optional<UserDto> getUserInfo(String id) {
        if (mockUsers == null || !mockUsers.containsKey(id)) {
            return Optional.empty();
        }

        return Optional.of(mockUsers.get(id));
    }
}
