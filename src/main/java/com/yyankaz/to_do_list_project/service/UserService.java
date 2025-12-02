package com.yyankaz.to_do_list_project.service;

import com.yyankaz.to_do_list_project.dto.UserCreateDto;
import com.yyankaz.to_do_list_project.dto.UserDto;
import com.yyankaz.to_do_list_project.dto.UserUpdateDto;

public interface UserService {
    UserDto findDyId(Long id);
    UserDto createUser(UserCreateDto createdDto);
    UserDto updateUser(UserUpdateDto updatedDto, Long id);
    void deleteUserById(Long id);
}
