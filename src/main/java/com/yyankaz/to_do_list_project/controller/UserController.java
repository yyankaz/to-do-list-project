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
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserCreateDto createdDto) {
        return userService.createUser(createdDto);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@Valid @RequestBody UserUpdateDto updatedDto, @PathVariable Long id) {
        return userService.updateUser(updatedDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
