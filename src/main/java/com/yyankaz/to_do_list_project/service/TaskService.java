package com.yyankaz.to_do_list_project.service;

import com.yyankaz.to_do_list_project.dto.TaskCreatedDto;
import com.yyankaz.to_do_list_project.dto.TaskDto;
import com.yyankaz.to_do_list_project.dto.TaskUpdateDto;


import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskCreatedDto createdDto);
    TaskDto updateTask(TaskUpdateDto updatedDto, Long id);
    TaskDto toggleFinished(Long id);
    TaskDto findTaskById(Long id);
    List<TaskDto> findByBoardId(Long boardId);
    void deleteTaskById(Long id);
}
