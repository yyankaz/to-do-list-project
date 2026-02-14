package com.yyankaz.to_do_list_project.dto;

import com.yyankaz.to_do_list_project.model.Board;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class TaskCreatedDto {
    @NotBlank(message = "Task can't be empty.")
    private String taskDescription;
    @NonNull
    private Long boardId;
    @NonNull
    private Boolean finished = false;
}
