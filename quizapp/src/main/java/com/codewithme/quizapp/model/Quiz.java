package com.codewithme.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String category;
    private String difficulty;

    @ManyToMany
    private List<Questions> questions;
}