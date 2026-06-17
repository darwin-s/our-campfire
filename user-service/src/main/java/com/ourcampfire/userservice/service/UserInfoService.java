package com.ourcampfire.userservice.service;

import com.ourcampfire.userservice.dto.UserDto;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

/**
 * Interface for user information retrieval
 */
public interface UserInfoService {
    /**
     * Get information about a user
     * @param id The id of the user
     * @return User information DTO if it exists
     */
    @PreAuthorize("(hasRole('READ_OWN_PROFILE') && authentication.name == #id) || (hasRole('READ_OTHER_PROFILES'))")
    Optional<UserDto> getUserInfo(String id);
}
