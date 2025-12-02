package com.yyankaz.to_do_list_project.mapper;

import com.yyankaz.to_do_list_project.dto.*;
import com.yyankaz.to_do_list_project.model.Task;
import com.yyankaz.to_do_list_project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(TaskCreatedDto dto);
    TaskDto toDto(Task task);
    void updateEntity(@MappingTarget Task task, TaskUpdateDto dto);
}
