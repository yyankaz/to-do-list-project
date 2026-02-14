package com.yyankaz.to_do_list_project.controller;

import com.yyankaz.to_do_list_project.dto.BoardCreatedDto;
import com.yyankaz.to_do_list_project.dto.BoardDto;
import com.yyankaz.to_do_list_project.dto.BoardUpdateDto;
import com.yyankaz.to_do_list_project.service.BoardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/all")
    public List<BoardDto> findAllByUser(){
        return boardService.findAllByUser();
    }

    @PostMapping("/create")
    public BoardDto createBoard(@Valid @RequestBody BoardCreatedDto createdDto) {
        log.info("BOARD CREATED: {}", createdDto.getBoardName());
        return boardService.createBoard(createdDto);
    }

    @PutMapping("/{id}")
    public BoardDto updateBoard(@Valid @RequestBody BoardUpdateDto updatedDto, @PathVariable Long id) {
        log.info("BOARD UPDATED: {}", updatedDto.getBoardName());
        return boardService.updateBoard(updatedDto, id);
    }

    @GetMapping("/{id}")
    public BoardDto findBoardById(@PathVariable Long id) {
        return boardService.findBoardById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBoardById(@PathVariable Long id) {
        boardService.deleteBoardById(id);
        log.info("BOARD DELETED: {}", id);
    }


}
