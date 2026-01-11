package com.yyankaz.to_do_list_project.service;

import com.yyankaz.to_do_list_project.dto.TaskCreatedDto;
import com.yyankaz.to_do_list_project.dto.TaskDto;
import com.yyankaz.to_do_list_project.dto.TaskUpdateDto;
import com.yyankaz.to_do_list_project.model.Board;
import com.yyankaz.to_do_list_project.model.Task;

public interface TaskService {
    TaskDto createTask(TaskCreatedDto createdDto);
    TaskDto updateTask(TaskUpdateDto updatedDto, Long id);
    TaskDto findTaskById(Long id);
    void deleteTaskById(Long id);
}
