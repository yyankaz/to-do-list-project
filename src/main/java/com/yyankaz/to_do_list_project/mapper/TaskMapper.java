package com.yyankaz.to_do_list_project.mapper;

import com.yyankaz.to_do_list_project.dto.*;
import com.yyankaz.to_do_list_project.model.Task;
import com.yyankaz.to_do_list_project.model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(TaskCreatedDto dto);
    @Mapping(target = "boardId", source = "board.id")
    TaskDto toDto(Task task);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Task task, TaskUpdateDto dto);
}
