package com.yyankaz.to_do_list_project.repository;

import com.yyankaz.to_do_list_project.model.Board;
import com.yyankaz.to_do_list_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findByIdAndUser(Long id, User user);
}
