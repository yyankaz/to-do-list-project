package com.yyankaz.to_do_list_project.controller;

import com.yyankaz.to_do_list_project.dto.UserCreateDto;
import com.yyankaz.to_do_list_project.dto.UserDto;
import com.yyankaz.to_do_list_project.dto.UserUpdateDto;
import com.yyankaz.to_do_list_project.service.UserService;
import com.yyankaz.to_do_list_project.serviceImpl.AuthService;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    @GetMapping
    public UserDto findUser() {
        return userService.findUser();
    }

    @PostMapping("/register")
    public UserDto createUser(@Valid @RequestBody UserCreateDto createdDto) {
        log.info("REGISTER CALLED: {}", createdDto.getUsername());

        UserDto savedUser = userService.createUser(createdDto);

        authService.autoLogin(savedUser.getUsername(), createdDto.getPassword());
        log.info("REGISTER FINISHED: {}", createdDto.getUsername());

        return savedUser;
    }

    @PutMapping
    public UserDto updateUser(@Valid @RequestBody UserUpdateDto updatedDto) {
        log.info("USER UPDATED: {}", updatedDto.getUsername());
        return userService.updateUser(updatedDto);
    }

    @DeleteMapping
    public void deleteUser() {
        Long id = userService.getCurrentUser().getId();
        userService.deleteUser();
        log.info("USER DELETED: {}", id);
    }
}
