package com.yyankaz.to_do_list_project.dto;

import com.yyankaz.to_do_list_project.model.enums.BoardColor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class BoardCreatedDto {
    @NotBlank(message = "Board name can't be empty.")
    //@Size(min = 1, max = )
    private String boardName;
    @NonNull
    private BoardColor color;
}
