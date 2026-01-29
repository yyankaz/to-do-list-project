package com.yyankaz.to_do_list_project.controller;

import com.yyankaz.to_do_list_project.dto.BoardCreatedDto;
import com.yyankaz.to_do_list_project.dto.BoardDto;
import com.yyankaz.to_do_list_project.dto.BoardUpdateDto;
import com.yyankaz.to_do_list_project.service.BoardService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public List<BoardDto> findAllByUser(){
        return boardService.findAllByUser();
    }

    @PostMapping("/create")
    public BoardDto createBoard(@Valid @RequestBody BoardCreatedDto createdDto) {
        return boardService.createBoard(createdDto);
    }

    @PutMapping("/{id}")
    public BoardDto updateBoard(@Valid @RequestBody BoardUpdateDto updatedDto, @PathVariable Long id) {
        return boardService.updateBoard(updatedDto, id);
    }

    @GetMapping("/{id}")
    public BoardDto findBoardById(@PathVariable Long id) {
        return boardService.findBoardById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteBoardById(@PathVariable Long id) {
        boardService.deleteBoardById(id);
    }


}
