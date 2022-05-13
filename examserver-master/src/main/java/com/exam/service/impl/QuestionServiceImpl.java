package com.exam.service.impl;

import com.exam.models.Exam.Category;
import com.exam.models.Exam.Question;
import com.exam.models.Exam.Quiz;
import com.exam.repo.QuestionRepository;
import com.exam.service.QuestionService;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository quesrepo;

    @Override
    public Question addQuestion(Question question) {
        return this.quesrepo.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.quesrepo.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>(this.quesrepo.findAll());
    }

    @Override
    public Question getQuestion(Long quesId) {
        return this.quesrepo.findById(quesId).get();
    }

    @Override
    public void deleteQuestion(Long quesId) {
        this.quesrepo.deleteById(quesId);
    }


    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz){
        return this.quesrepo.findByQuiz(quiz);
    }

}
