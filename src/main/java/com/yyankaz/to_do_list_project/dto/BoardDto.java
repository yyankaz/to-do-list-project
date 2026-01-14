package com.yyankaz.to_do_list_project.dto;

import com.yyankaz.to_do_list_project.model.Task;
import com.yyankaz.to_do_list_project.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class BoardDto {
    private Long id;
    @NotBlank(message = "Board name can't be empty.")
    private String boardName;
    private User user;
    private List<Task> tasks = new ArrayList<>();
}
