package com.yyankaz.to_do_list_project.repository;

import com.yyankaz.to_do_list_project.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
