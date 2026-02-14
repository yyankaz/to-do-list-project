package com.yyankaz.to_do_list_project.dto;


import com.yyankaz.to_do_list_project.model.enums.BoardColor;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class BoardUpdateDto {
    @NotBlank(message = "Board name can't be empty.")
    private String boardName;
    @NonNull
    private BoardColor color;
}
