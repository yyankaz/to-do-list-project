package com.yyankaz.to_do_list_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Username can't be empty.")
    private String username;
    @NotBlank(message = "Password can't be empty.")
    @Size(min = 8, message = "Password can't have least than 8 symbols.")
    private String password;
    @OneToMany
    private List<Board> boards = new ArrayList<>();
}
