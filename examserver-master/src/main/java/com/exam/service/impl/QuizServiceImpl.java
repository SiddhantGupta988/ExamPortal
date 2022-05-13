package com.exam.service.impl;

import com.exam.models.Exam.Category;
import com.exam.models.Exam.Question;
import com.exam.models.Exam.Quiz;
import com.exam.repo.QuizRepository;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizrepo;


    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizrepo.save(quiz);
    }

    @Override
    public void deleteQuiz(Long qid) {
        System.out.println("i am in delete quizservice impl");
        this.quizrepo.deleteById(qid);
    }

    @Override
    public Set<Quiz> getQuizes() {
        return new LinkedHashSet<>(this.quizrepo.findAll());
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizrepo.save(quiz);
    }

    @Override
    public Quiz getQuiz(Long qid) {
        return this.quizrepo.findById(qid).get();
    }

    @Override
    public List<Quiz> getQuizzesOfCategory(Category c) {
        return this.quizrepo.findByCategory(c);
    }


}
