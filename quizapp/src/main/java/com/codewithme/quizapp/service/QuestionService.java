package com.codewithme.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithme.quizapp.dao.QuestionsDao;
import com.codewithme.quizapp.model.Questions;

@Service 
public class QuestionService {
    @Autowired
    QuestionsDao questionsDao;

    public List<Questions> getAllQuestions() {
        return questionsDao.findAll();
    }
}