package com.yyankaz.to_do_list_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    @OneToMany
    private List<Board> boards = new ArrayList<>();
}
