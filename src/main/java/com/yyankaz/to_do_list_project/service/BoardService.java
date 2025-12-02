package com.yyankaz.to_do_list_project.service;

import com.yyankaz.to_do_list_project.dto.BoardCreatedDto;
import com.yyankaz.to_do_list_project.dto.BoardDto;
import com.yyankaz.to_do_list_project.dto.BoardUpdateDto;

public interface BoardService {
    BoardDto createBoard(BoardCreatedDto createdDto);
    BoardDto updateBoard(BoardUpdateDto updatedDto, Long id);
    BoardDto findBoardById(Long id);
    void deleteBoardById(Long id);
}
