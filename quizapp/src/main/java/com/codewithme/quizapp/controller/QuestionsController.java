package com.codewithme.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codewithme.quizapp.model.Questions;
import com.codewithme.quizapp.service.QuestionService;

@RestController
@RequestMapping

public class QuestionsController{

    @Autowired
    QuestionService QuestionService;

    @GetMapping("allQuestions")
    public List <Questions> getAllQuetions(){
        return QuestionService.getAllQuestions();
    }
} 
