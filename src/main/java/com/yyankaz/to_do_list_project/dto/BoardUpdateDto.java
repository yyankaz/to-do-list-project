package com.yyankaz.to_do_list_project.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardUpdateDto {
    @NotBlank(message = "Board name can't be empty.")
    private String boardName;
}
