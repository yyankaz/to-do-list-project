package com.yyankaz.to_do_list_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserUpdateDto {
    @NotBlank(message = "Username can't be empty.")
    @Size(min = 5, max = 32)
    private String username;
    @NotBlank(message = "Password can't be empty.")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,32}$",
            message = "Password must be 8-32 characters long and include uppercase, lowercase, and digit"
    )
    private String password;
}
