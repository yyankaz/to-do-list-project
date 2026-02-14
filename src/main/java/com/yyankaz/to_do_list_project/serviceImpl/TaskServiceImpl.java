package com.yyankaz.to_do_list_project.serviceImpl;

import com.yyankaz.to_do_list_project.dto.TaskCreatedDto;
import com.yyankaz.to_do_list_project.dto.TaskDto;
import com.yyankaz.to_do_list_project.dto.TaskUpdateDto;
import com.yyankaz.to_do_list_project.exception.NotFoundException;
import com.yyankaz.to_do_list_project.mapper.TaskMapper;
import com.yyankaz.to_do_list_project.model.Board;
import com.yyankaz.to_do_list_project.model.Task;
import com.yyankaz.to_do_list_project.repository.TaskRepository;
import com.yyankaz.to_do_list_project.service.BoardService;
import com.yyankaz.to_do_list_project.service.TaskService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final BoardService boardService;

    @Override
    public TaskDto createTask(TaskCreatedDto createdDto) {
        log.info("TASK CREATION CALLED: taskDescription = {}", createdDto.getTaskDescription());
        Board board = boardService.findByIdAndUser(createdDto.getBoardId());
        Task task = taskMapper.toEntity(createdDto);
        task.setBoard(board);
        task.setFinished(false);
        Task saved = taskRepository.save(task);
        log.info("TASK SUCCESSFULLY CREATED: taskId = {}, taskDescription = {}", saved.getId(), saved.getTaskDescription());
        return taskMapper.toDto(saved);
    }

    @Override
    public TaskDto updateTask(TaskUpdateDto updatedDto, Long id) {
        log.info("TASK UPDATING CALLED: taskId = {}", id);
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found"));
        boardService.findByIdAndUser(task.getBoard().getId());
        taskMapper.updateEntity(task, updatedDto);
        Task saved = taskRepository.save(task);
        log.info("TASK SUCCESSFULLY UPDATED: taskId = {}, taskDescription = {}", saved.getId(), saved.getTaskDescription());
        return taskMapper.toDto(saved);
    }

    @Override
    public TaskDto toggleFinished(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found"));
        boardService.findByIdAndUser(task.getBoard().getId());
        task.setFinished(!task.getFinished());
        Task saved = taskRepository.save(task);
        log.info("TASK STATUS SUCCESSFULLY TOGGLED: taskId = {}", saved.getId());
        return taskMapper.toDto(saved);
    }

    @Override
    public TaskDto findTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found"));
        boardService.findByIdAndUser(task.getBoard().getId());
        return taskMapper.toDto(task);
    }

    @Override
    public List<TaskDto> findByBoardId(Long boardId) {
        List<Task> tasks = taskRepository.findByBoardId(boardId);
        return tasks
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @Override
    public void deleteTaskById(Long id) {
        log.info("TASK DELETING CALLED: taskId = {}", id);
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found"));

        boardService.findByIdAndUser(task.getBoard().getId());
        task.getBoard().getTasks().remove(task);
    }
}
