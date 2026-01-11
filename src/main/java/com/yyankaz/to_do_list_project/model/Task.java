package com.yyankaz.to_do_list_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    private Long id;
    private Boolean finished;
    private String taskDescription;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
