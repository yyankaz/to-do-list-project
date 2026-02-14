package com.yyankaz.to_do_list_project.serviceImpl;

import com.yyankaz.to_do_list_project.dto.BoardCreatedDto;
import com.yyankaz.to_do_list_project.dto.BoardDto;
import com.yyankaz.to_do_list_project.dto.BoardUpdateDto;
import com.yyankaz.to_do_list_project.exception.NotFoundException;
import com.yyankaz.to_do_list_project.mapper.BoardMapper;
import com.yyankaz.to_do_list_project.model.Board;
import com.yyankaz.to_do_list_project.model.User;
import com.yyankaz.to_do_list_project.repository.BoardRepository;
import com.yyankaz.to_do_list_project.service.BoardService;
import com.yyankaz.to_do_list_project.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
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
                .orElseThrow(() -> new NotFoundException("Board not found"));
    }

    @Override
    public List<BoardDto> findAllByUser() {

        List<Board> boards = boardRepository.findAllByUser(userService.getCurrentUser());
        return boards
                .stream()
                .map(boardMapper::toDto)
                .toList();
    }

    @Override
    public BoardDto createBoard(BoardCreatedDto createdDto) {
        log.info("BOARD CREATION CALLED: boardName = {}", createdDto.getBoardName());
        User currentUser = userService.getCurrentUser();
        Board board = boardMapper.toEntity(createdDto);
        board.setUser(currentUser);
        Board saved = boardRepository.save(board);
        log.info("BOARD SUCCESSFULLY CREATED: boardId = {}, boardName = {}", saved.getId(), saved.getBoardName());
        return boardMapper.toDto(saved);
    }

    @Override
    public BoardDto updateBoard(BoardUpdateDto updatedDto, Long id) {
        log.info("BOARD UPDATING CALLED: boardId = {}", id);
        Board board = findByIdAndUser(id);

        board.setBoardName(updatedDto.getBoardName());
        board.setColor(updatedDto.getColor());

        Board saved = boardRepository.save(board);
        log.info("BOARD SUCCESSFULLY UPDATED: boardId = {}, boardName = {}", saved.getId(), saved.getBoardName());
        return boardMapper.toDto(saved);

    }

    @Override
    public BoardDto findBoardById(Long id) {
        Board board = findByIdAndUser(id);
        return boardMapper.toDto(board);
    }


    @Override
    public void deleteBoardById(Long id) {
        log.info("BOARD DELETING CALLED: boardId = {}", id);
        Board board = findByIdAndUser(id);
        board.getUser().getBoards().remove(board);
    }
}
