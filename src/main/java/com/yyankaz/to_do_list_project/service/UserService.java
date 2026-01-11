package com.yyankaz.to_do_list_project.service;

import com.yyankaz.to_do_list_project.dto.UserCreateDto;
import com.yyankaz.to_do_list_project.dto.UserDto;
import com.yyankaz.to_do_list_project.dto.UserUpdateDto;
import com.yyankaz.to_do_list_project.model.User;

public interface UserService {
    User getCurrentUser();
    UserDto findUser();
    UserDto createUser(UserCreateDto createdDto);
    UserDto updateUser(UserUpdateDto updatedDto);
    void deleteUser();
}
