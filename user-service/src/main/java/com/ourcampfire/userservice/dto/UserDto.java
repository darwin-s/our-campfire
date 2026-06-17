package com.ourcampfire.userservice.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * User DTO object representation
 */
@Data
@Validated
public class UserDto {
    private String id;
    private String username;
    @Email
    private String email;
    private String firstName;
    private String lastName;
    private String pictureUrl;
}
