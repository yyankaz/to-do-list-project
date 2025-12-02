package com.yyankaz.to_do_list_project.serviceImpl;

import com.yyankaz.to_do_list_project.dto.UserCreateDto;
import com.yyankaz.to_do_list_project.dto.UserDto;
import com.yyankaz.to_do_list_project.dto.UserUpdateDto;
import com.yyankaz.to_do_list_project.mapper.UserMapper;
import com.yyankaz.to_do_list_project.model.User;
import com.yyankaz.to_do_list_project.repository.UserRepository;
import com.yyankaz.to_do_list_project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    public UserDto createUser(UserCreateDto createdDto) {
        User user = userMapper.toEntity(createdDto);
        User saved = userRepository.save(user);
        return userMapper.toDto(saved);
    }

    @Override
    public UserDto updateUser(UserUpdateDto updatedDto, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateEntity(user, updatedDto);
        User saved = userRepository.save(user);
        return userMapper.toDto(saved);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
