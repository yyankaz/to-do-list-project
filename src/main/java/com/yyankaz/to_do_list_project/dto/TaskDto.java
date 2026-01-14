package com.yyankaz.to_do_list_project.dto;

import com.yyankaz.to_do_list_project.model.Board;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskDto {
    private Long id;
    @NotBlank(message = "Task can't be empty.")
    private Boolean finished;
    private String taskDescription;
    private Board board;
}
