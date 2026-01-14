package com.yyankaz.to_do_list_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreateDto {
    @NotBlank(message = "Username can't be empty.")
    private String username;
    @NotBlank(message = "Password can't be empty.")
    @Size(min = 8, message = "Password can't have least than 8 symbols.")
    private String password;
}
