package com.yyankaz.to_do_list_project.serviceImpl;

import com.yyankaz.to_do_list_project.dto.BoardCreatedDto;
import com.yyankaz.to_do_list_project.dto.BoardDto;
import com.yyankaz.to_do_list_project.dto.BoardUpdateDto;
import com.yyankaz.to_do_list_project.mapper.BoardMapper;
import com.yyankaz.to_do_list_project.model.Board;
import com.yyankaz.to_do_list_project.repository.BoardRepository;
import com.yyankaz.to_do_list_project.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;
    private BoardMapper boardMapper;

    @Override
    public BoardDto createBoard(BoardCreatedDto createdDto) {
        Board board = boardMapper.toEntity(createdDto);
        Board saved = boardRepository.save(board);
        return boardMapper.toDto(saved);
    }

    @Override
    public BoardDto updateBoard(BoardUpdateDto updatedDto, Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        boardMapper.updateEntity(board, updatedDto);
        Board saved = boardRepository.save(board);
        return boardMapper.toDto(saved);
    }

    @Override
    public BoardDto findBoardById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        return boardMapper.toDto(board);
    }

    @Override
    public void deleteBoardById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        boardRepository.delete(board);
    }
}
