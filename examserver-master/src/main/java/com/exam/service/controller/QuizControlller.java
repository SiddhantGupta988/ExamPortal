package com.exam.service.controller;

import com.exam.models.Exam.Category;
import com.exam.models.Exam.Quiz;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizControlller {

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    @GetMapping("/")
    public ResponseEntity<Set<Quiz>> getAllQuizes(){
        return ResponseEntity.ok(this.quizService.getQuizes());
    }

    @GetMapping("/{qid}")
    public Quiz getQuiz(@PathVariable("qid") Long qid )
    {
        return this.quizService.getQuiz(qid);
    }

    @DeleteMapping("/{qid}")
    public  void deleteQuiz(@PathVariable("qid") Long qid){

        this.quizService.deleteQuiz(qid);
    }

    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable("cid")Long cid)
    {
        Category c= new Category();
        c.setCid(cid);
        return  this.quizService.getQuizzesOfCategory(c);
    }
}
