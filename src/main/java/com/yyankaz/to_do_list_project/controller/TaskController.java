package com.yyankaz.to_do_list_project.controller;

import com.yyankaz.to_do_list_project.dto.TaskCreatedDto;
import com.yyankaz.to_do_list_project.dto.TaskDto;
import com.yyankaz.to_do_list_project.dto.TaskUpdateDto;
import com.yyankaz.to_do_list_project.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    public TaskDto createTask(@Valid @RequestBody TaskCreatedDto createdDto) {
        log.info("TASK CREATED: {}", createdDto.getTaskDescription());
        return taskService.createTask(createdDto);
    }

    @GetMapping("/board/{boardId}")
    public List<TaskDto> findByBoardId(@PathVariable Long boardId){
        return taskService.findByBoardId(boardId);
    }

    @PatchMapping("/{id}/toggle")
    public TaskDto toggleFinished(@PathVariable Long id) {
        log.info("TASK'S FINISHED STATUS TOGGLED: {}", id);
        return taskService.toggleFinished(id);
    }

    @PutMapping("/{id}")
    public TaskDto updateTask(@Valid @RequestBody TaskUpdateDto updatedDto, @PathVariable Long id) {
        log.info("TASK UPDATED: {}", updatedDto.getTaskDescription());
        return taskService.updateTask(updatedDto, id);
    }

    @GetMapping("/{id}")
    public TaskDto findTaskById(@PathVariable Long id) {
        return taskService.findTaskById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        log.info("TASK DELETED: {}", id);
    }

}
