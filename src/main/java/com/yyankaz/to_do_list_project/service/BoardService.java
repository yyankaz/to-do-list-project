package com.yyankaz.to_do_list_project.service;

import com.yyankaz.to_do_list_project.dto.BoardCreatedDto;
import com.yyankaz.to_do_list_project.dto.BoardDto;
import com.yyankaz.to_do_list_project.dto.BoardUpdateDto;
import com.yyankaz.to_do_list_project.model.Board;
import com.yyankaz.to_do_list_project.model.User;

import java.util.List;

public interface BoardService {
    Board findByIdAndUser(Long id);
    List<BoardDto> findAllByUser();
    BoardDto createBoard(BoardCreatedDto createdDto);
    BoardDto updateBoard(BoardUpdateDto updatedDto, Long id);
    BoardDto findBoardById(Long id);
    void deleteBoardById(Long id);
}
