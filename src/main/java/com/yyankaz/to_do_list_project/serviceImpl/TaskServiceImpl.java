package com.yyankaz.to_do_list_project.serviceImpl;

import com.yyankaz.to_do_list_project.dto.TaskCreatedDto;
import com.yyankaz.to_do_list_project.dto.TaskDto;
import com.yyankaz.to_do_list_project.dto.TaskUpdateDto;
import com.yyankaz.to_do_list_project.mapper.TaskMapper;
import com.yyankaz.to_do_list_project.model.Task;
import com.yyankaz.to_do_list_project.repository.TaskRepository;
import com.yyankaz.to_do_list_project.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    @Override
    public TaskDto createTask(TaskCreatedDto createdDto) {
        Task task = taskMapper.toEntity(createdDto);
        Task saved = taskRepository.save(task);
        return taskMapper.toDto(saved);
    }

    @Override
    public TaskDto updateTask(TaskUpdateDto updatedDto, Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskMapper.updateEntity(task, updatedDto);
        Task saved = taskRepository.save(task);
        return taskMapper.toDto(saved);
    }

    @Override
    public TaskDto findTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return taskMapper.toDto(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }
}
