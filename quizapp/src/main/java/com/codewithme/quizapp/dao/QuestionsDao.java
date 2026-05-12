package com.codewithme.quizapp.dao;

import org.springframework.stereotype.Repository;

import com.codewithme.quizapp.model.Questions;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuestionsDao extends JpaRepository<Questions, Integer> {
    
}