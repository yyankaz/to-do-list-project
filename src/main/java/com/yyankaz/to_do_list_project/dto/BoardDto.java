package com.yyankaz.to_do_list_project.dto;

import com.yyankaz.to_do_list_project.model.Task;
import com.yyankaz.to_do_list_project.model.User;
import com.yyankaz.to_do_list_project.model.enums.BoardColor;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class BoardDto {
    private Long id;
    @NotBlank(message = "Board name can't be empty.")
    private String boardName;
    @NonNull
    private BoardColor color;
    private Long userId;
    private List<Long> taskIds = new ArrayList<>();
}
