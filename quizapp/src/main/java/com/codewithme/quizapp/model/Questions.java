package com.codewithme.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Questions{

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE)
    private int id;
    private String question_text;
    private String category;
    private String difficulty;
    private java.time.LocalDateTime created_at;

    
}