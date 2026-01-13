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
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final BoardService boardService;

    @Override
    public TaskDto createTask(TaskCreatedDto createdDto) {
        Board board = boardService.findByIdAndUser(createdDto.getBoardId());
        Task task = taskMapper.toEntity(createdDto);
        task.setBoard(board);
        Task saved = taskRepository.save(task);
        return taskMapper.toDto(saved);
    }

    @Override
    public TaskDto updateTask(TaskUpdateDto updatedDto, Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found"));
        boardService.findByIdAndUser(task.getBoard().getId());
        taskMapper.updateEntity(task, updatedDto);
        Task saved = taskRepository.save(task);
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
    public void deleteTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found"));
        boardService.findByIdAndUser(task.getBoard().getId());
        taskRepository.delete(task);
    }
}
