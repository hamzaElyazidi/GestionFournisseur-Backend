package ma.emsi.evaluationFournisseur.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.evaluationFournisseur.dtos.QuestionDTO;
import ma.emsi.evaluationFournisseur.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    QuestionService questionService ;
    @GetMapping("/questions")
    public List<QuestionDTO> getAllQuestions()
    {
        return questionService.getAllQuestions() ;
    }

}
