package com.yyankaz.to_do_list_project.controller;

import com.yyankaz.to_do_list_project.dto.UserCreateDto;
import com.yyankaz.to_do_list_project.dto.UserDto;
import com.yyankaz.to_do_list_project.dto.UserUpdateDto;
import com.yyankaz.to_do_list_project.model.User;
import com.yyankaz.to_do_list_project.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Value;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public UserDto findUser() {
        return userService.findUser();
    }

    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserCreateDto createdDto) {
        return userService.createUser(createdDto);
    }

    @PutMapping
    public UserDto updateUser(@Valid @RequestBody UserUpdateDto updatedDto) {
        return userService.updateUser(updatedDto);
    }

    @DeleteMapping
    public void deleteUser() {
        userService.deleteUser();
    }
}
