package com.exam.service.controller;

import com.exam.models.Exam.Question;
import com.exam.models.Exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    public QuestionService questionService;

    @Autowired
    public QuizService quizService;



    @PostMapping("/")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }
    @PutMapping("/")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getAllQuestion(@PathVariable("qid") Long qid)
    {
        Quiz quiz  = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List<Question>list = new ArrayList<>(questions);
        if(list.size()> Integer.parseInt(quiz.getNoOfQuestion())){
            list = list.subList(0,Integer.parseInt(quiz.getNoOfQuestion()+1));
        }
        list.forEach((q)->{
            q.setAnswer("");
        });
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{quesId}")
    public  ResponseEntity<?> getQuestion(@PathVariable("quesId") Long quesId){
        return ResponseEntity.ok(this.questionService.getQuestion(quesId));
    }

    @DeleteMapping("/{quesId}")
    public void deleteQues(@PathVariable("quesId") Long quesId)
    {
        System.out.println(" i am in delete mapping");
       this.questionService.deleteQuestion(quesId);
    }

    @GetMapping("/")
    public Set<Question> getAllQuestion()
    {
        return new HashSet<>(this.questionService.getQuestions());
    }

    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions)
    {
        System.out.println(questions);
        double marksgot =0;
        int correctAnswer =0;
        int attempted = 0;
       for(Question q:questions)
       {
            Question question = this.questionService.getQuestion(q.getQuesId());

            if(question.getAnswer().equals(q.getGivenAnswer()))
            {

                correctAnswer++;
                double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/Double.parseDouble(String.valueOf(questions.size()));
                marksgot += marksSingle;
            }
            if(q.getGivenAnswer()!=null)
                attempted++;


        };
       Map<String,Object>  map = Map.of("marksGot",marksgot,"correctAnswers",correctAnswer,"attempted",attempted);
        return ResponseEntity.ok(map);
    }



}
