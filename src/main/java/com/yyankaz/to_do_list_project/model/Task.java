package com.yyankaz.to_do_list_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Boolean finished = false;
    private String taskDescription;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
