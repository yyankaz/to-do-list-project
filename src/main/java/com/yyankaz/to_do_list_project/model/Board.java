package com.yyankaz.to_do_list_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Board {
    @Id
    private Long id;
    private String boardName;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Task> tasks = new ArrayList<>();
}
