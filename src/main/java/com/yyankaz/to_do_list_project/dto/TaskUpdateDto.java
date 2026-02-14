package com.yyankaz.to_do_list_project.dto;

import com.yyankaz.to_do_list_project.model.Board;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class TaskUpdateDto {
    @NotBlank(message = "Task can't be empty.")
    private String taskDescription;
    private Boolean finished = false;
}
