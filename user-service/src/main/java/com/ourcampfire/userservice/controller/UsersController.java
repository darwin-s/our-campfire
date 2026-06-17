package com.ourcampfire.userservice.controller;

import com.ourcampfire.userservice.dto.UserDto;
import com.ourcampfire.userservice.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Controller class for user related operations
 */
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UsersController {

    private final UserInfoService userInfoService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserInfo(@PathVariable final String userId) {
        Optional<UserDto> user = userInfoService.getUserInfo(userId);

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
