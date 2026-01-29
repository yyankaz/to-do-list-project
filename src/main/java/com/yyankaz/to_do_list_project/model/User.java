package com.yyankaz.to_do_list_project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    @Getter
    private String username;
    @Getter
    private String password;
    @OneToMany
    private List<Board> boards = new ArrayList<>();
}
