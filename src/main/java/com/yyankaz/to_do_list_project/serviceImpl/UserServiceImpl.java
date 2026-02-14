package com.yyankaz.to_do_list_project.serviceImpl;

import com.yyankaz.to_do_list_project.dto.UserCreateDto;
import com.yyankaz.to_do_list_project.dto.UserDto;
import com.yyankaz.to_do_list_project.dto.UserUpdateDto;
import com.yyankaz.to_do_list_project.exception.NotFoundException;
import com.yyankaz.to_do_list_project.mapper.UserMapper;
import com.yyankaz.to_do_list_project.model.User;
import com.yyankaz.to_do_list_project.repository.UserRepository;
import com.yyankaz.to_do_list_project.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getCurrentUser(){
        String username = Objects.requireNonNull(SecurityContextHolder
                        .getContext()
                        .getAuthentication())
                .getName();

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public UserDto findUser() {
        User user = getCurrentUser();
        return userMapper.toDto(user);
    }

    @Override
    public UserDto createUser(UserCreateDto createdDto) {
        log.info("USER CREATION CALLED: username = {}", createdDto.getUsername());
        if(userRepository.existsByUsername(createdDto.getUsername())){
            throw new RuntimeException("Username already exist.");
        }
        User user = userMapper.toEntity(createdDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saved = userRepository.save(user);
        log.info("USER SUCCESSFULLY CREATED: userId = {}, username = {}", saved.getId(), saved.getUsername());
        return userMapper.toDto(saved);
    }

    @Override
    public UserDto updateUser(UserUpdateDto updatedDto) {
        log.info("USER UPDATING CALLED: username = {}", updatedDto.getUsername());
        User user = getCurrentUser();
        userMapper.updateEntity(user, updatedDto);
        User saved = userRepository.save(user);
        log.info("USER SUCCESSFULLY UPDATED: userId = {}, username = {}", saved.getId(), saved.getUsername());
        return userMapper.toDto(saved);
    }

    @Override
    public void deleteUser() {
        User user = getCurrentUser();
        log.info("USER DELETING CALLED: userId = {}, username = {}", user.getId(), user.getUsername());
        userRepository.delete(user);
    }
}
