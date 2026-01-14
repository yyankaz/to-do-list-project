package com.yyankaz.to_do_list_project.dto;

import com.yyankaz.to_do_list_project.model.Board;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotBlank(message = "Username can't be empty.")
    private String username;
    private List<Board> boards = new ArrayList<>();
}
