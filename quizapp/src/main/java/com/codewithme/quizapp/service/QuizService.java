package com.codewithme.quizapp.service;

import com.codewithme.quizapp.dao.QuestionsDao;
import com.codewithme.quizapp.dao.QuizDao;
import com.codewithme.quizapp.model.Questions;
import com.codewithme.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuestionsDao questionsDao;

    @Autowired
    private QuizDao quizDao;

    public List<Questions> getAllQuestions() {
        return questionsDao.findAll();
    }

    public List<Questions> findRandomQuestionsByCategory(String category, int num) {
        return questionsDao.findRandomQuestionsByCategory(category, num);
    }

    public ResponseEntity<String> createQuiz(String category, 
                                           String difficulty, 
                                           String title, 
                                           int numQuestions) {
        
        List<Questions> questions = findRandomQuestionsByCategory(category, numQuestions);
        
        if (questions.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("No questions found for category: " + category);
        }

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setCategory(category);
        quiz.setDifficulty(difficulty);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return ResponseEntity.ok("Quiz created successfully! ID: " + quiz.getId());
    }
}