package com.codewithme.quizapp.controller;

import com.codewithme.quizapp.model.Questions;
import com.codewithme.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Questions> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}