package com.yyankaz.to_do_list_project.mapper;

import com.yyankaz.to_do_list_project.dto.*;
import com.yyankaz.to_do_list_project.model.Board;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    Board toEntity(BoardCreatedDto dto);
    BoardDto toDto(Board board);
    //void updateEntity(@MappingTarget User user, UserUpdateDto dto);
}
