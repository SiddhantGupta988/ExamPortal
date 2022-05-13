package com.exam.repo;

import com.exam.models.Exam.Category;
import com.exam.models.Exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

    public List<Quiz> findByCategory(Category category);
}
