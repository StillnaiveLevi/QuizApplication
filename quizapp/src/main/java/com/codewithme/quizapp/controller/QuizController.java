package com.codewithme.quizapp.controller;

import com.codewithme.quizapp.model.Quiz;
import com.codewithme.quizapp.service.QuestionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/createQuiz")
    @CrossOrigin("*")
    public ResponseEntity<String> createQuiz(
            @RequestParam String category,
            @RequestParam String difficulty,
            @RequestParam String title,
            @RequestParam(defaultValue = "5") int numQuestions) {   // default = 5 questions
        
        return questionService.createQuiz(category, difficulty, title, numQuestions);
    }
    @GetMapping("/allQuizzes")
    public List<Quiz> getAllQuizzes() {
        return questionService.getAllQuizes();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable int id) {
        return questionService.getQuizById(id);
    }
}