package com.yyankaz.to_do_list_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Board name can't be empty.")
    private String boardName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany
    private List<Task> tasks = new ArrayList<>();
}
