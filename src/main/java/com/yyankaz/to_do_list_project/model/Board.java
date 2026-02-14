package com.yyankaz.to_do_list_project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yyankaz.to_do_list_project.model.enums.BoardColor;
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
    private String boardName;
    @Enumerated(EnumType.STRING)
    private BoardColor color;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();
}
