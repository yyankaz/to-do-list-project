package com.yyankaz.to_do_list_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Table {
    @Id
    private Long id;
    private String tableName;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Task> tasks;
}
