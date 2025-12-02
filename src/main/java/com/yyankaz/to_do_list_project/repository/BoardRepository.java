package com.yyankaz.to_do_list_project.repository;

import com.yyankaz.to_do_list_project.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
