package com.yyankaz.to_do_list_project.serviceImpl;

import com.yyankaz.to_do_list_project.dto.BoardCreatedDto;
import com.yyankaz.to_do_list_project.dto.BoardDto;
import com.yyankaz.to_do_list_project.dto.BoardUpdateDto;
import com.yyankaz.to_do_list_project.mapper.BoardMapper;
import com.yyankaz.to_do_list_project.model.Board;
import com.yyankaz.to_do_list_project.model.User;
import com.yyankaz.to_do_list_project.repository.BoardRepository;
import com.yyankaz.to_do_list_project.service.BoardService;
import com.yyankaz.to_do_list_project.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;
    private final UserService userService;

    @Override
    public Board findByIdAndUser(Long id){
        User currentUser = userService.getCurrentUser();
        return boardRepository.findByIdAndUser(id, currentUser)
                .orElseThrow(() -> new RuntimeException("Board not found"));
    }

    @Override
    public BoardDto createBoard(BoardCreatedDto createdDto) {
        User currentUser = userService.getCurrentUser();
        Board board = boardMapper.toEntity(createdDto);
        board.setUser(currentUser);
        Board saved = boardRepository.save(board);
        return boardMapper.toDto(saved);
    }

    @Override
    public BoardDto updateBoard(BoardUpdateDto updatedDto, Long id) {
        Board board = findByIdAndUser(id);
        boardMapper.updateEntity(board, updatedDto);
        Board saved = boardRepository.save(board);
        return boardMapper.toDto(saved);
    }

    @Override
    public BoardDto findBoardById(Long id) {
        Board board = findByIdAndUser(id);
        return boardMapper.toDto(board);
    }

    @Override
    public void deleteBoardById(Long id) {
        Board board = findByIdAndUser(id);
        boardRepository.delete(board);
    }
}
