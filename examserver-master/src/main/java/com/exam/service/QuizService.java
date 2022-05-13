package com.exam.service;
import com.exam.models.Exam.Category;
import com.exam.models.Exam.Question;
import com.exam.models.Exam.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);
    public void  deleteQuiz(Long qid);
    public Set<Quiz> getQuizes();
    public  Quiz updateQuiz(Quiz quiz);
    public Quiz  getQuiz(Long qid);

   public List<Quiz> getQuizzesOfCategory(Category c);
}
