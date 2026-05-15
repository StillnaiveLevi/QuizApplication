package com.codewithme.quizapp.dao;

import com.codewithme.quizapp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsDao extends JpaRepository<Questions, Integer> {

    @Query(value = "SELECT * FROM questions WHERE category = :category " +
                   "ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
    List<Questions> findRandomQuestionsByCategory(@Param("category") String category,
                                                  @Param("num") int num);
}