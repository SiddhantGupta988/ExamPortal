package com.exam.models.Exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Quiz {


    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private  Long qid;


    private String title;
    private boolean active;
    private String description;
    private String maxMarks;
    private  String noOfQuestion;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    public Quiz() {
    }
    @OneToMany(mappedBy="quiz",fetch= FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Question> questions = new LinkedHashSet<>();

    public Quiz(Long qid,String title, boolean active, String description, String maxMarks, String noOfQuestion, Category category, Set<Question> questions) {
        this.qid = qid;
        this.title = title;
        this.active = active;
        this.description = description;
        this.maxMarks = maxMarks;
        this.noOfQuestion = noOfQuestion;
        this.category = category;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public void setNoOfQuestion(String noOfQuestion) {
        this.noOfQuestion = noOfQuestion;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "title='" + title + '\'' +
                ", active=" + active +
                ", description='" + description + '\'' +
                ", maxMarks='" + maxMarks + '\'' +
                ", noOfQuestion='" + noOfQuestion + '\'' +
                '}';
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public String getNoOfQuestion() {
        return noOfQuestion;
    }
}
