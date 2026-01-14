package com.yyankaz.to_do_list_project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    @OneToMany
    private List<Board> boards = new ArrayList<>();
}
