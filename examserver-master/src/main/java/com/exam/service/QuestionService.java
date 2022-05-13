package com.exam.service;

import com.exam.models.Exam.Question;
import com.exam.models.Exam.Quiz;

import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public  Question getQuestion(Long quesId);
    public void deleteQuestion(Long quesId);
    public Set<Question> getQuestionOfQuiz(Quiz quiz);



}
