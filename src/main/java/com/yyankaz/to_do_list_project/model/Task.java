package com.yyankaz.to_do_list_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
    @Id
    private Long id;
    private Boolean finished;
    private String taskDescription;
    @ManyToOne
    private Board board;
}
