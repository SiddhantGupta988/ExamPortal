package com.exam.models.Exam;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
public class Question {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO )
    private Long quesId;
    @Column(length =5000)
    private String content;
    private String option1;
    private  String option2;
    private String option3;
    private  String option4;
    private String image;

    private  String answer;
    private String givenAnswer;

    public String getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    @Transient
    private String givenanswer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;

    private Question(){

    }

    public Question(String content, String option1, String option2, String option3, String option4, String image, Quiz quiz) {
        this.content = content;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.image = image;
        this.quiz = quiz;
    }

    public Question(Long quesId, String content, String option1, String option2, String option3, String option4, String image, String answer, Quiz quiz) {
        this.quesId = quesId;
        this.content = content;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.image = image;
        this.answer = answer;
        this.quiz = quiz;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getImage() {
        return image;
    }

    public Long getQuesId(){return quesId;}

    public void setImage(String image) {
        this.image = image;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    public void setQuesId(Long quesId) {
        this.quesId = quesId;
    }
}
