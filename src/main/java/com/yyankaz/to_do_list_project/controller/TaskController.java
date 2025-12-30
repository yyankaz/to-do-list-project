package com.yyankaz.to_do_list_project.controller;

import com.yyankaz.to_do_list_project.dto.TaskCreatedDto;
import com.yyankaz.to_do_list_project.dto.TaskDto;
import com.yyankaz.to_do_list_project.dto.TaskUpdateDto;
import com.yyankaz.to_do_list_project.model.Task;
import com.yyankaz.to_do_list_project.service.TaskService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public TaskDto createTask(@Valid @RequestBody TaskCreatedDto createdDto) {
        return taskService.createTask(createdDto);
    }

    @PutMapping("/{id}")
    public TaskDto updateTask(@Valid @RequestBody TaskUpdateDto updatedDto, @PathVariable Long id) {
        return taskService.updateTask(updatedDto, id);
    }

    @GetMapping("/{id}")
    public TaskDto findTaskById(@PathVariable Long id) {
        return taskService.findTaskById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }

}
