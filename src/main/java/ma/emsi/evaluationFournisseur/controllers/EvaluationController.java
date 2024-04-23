package ma.emsi.evaluationFournisseur.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.evaluationFournisseur.dtos.EvaluationDTO;
import ma.emsi.evaluationFournisseur.dtos.ScoreDTO;
import ma.emsi.evaluationFournisseur.entities.Evaluation;
import ma.emsi.evaluationFournisseur.entities.Project;
import ma.emsi.evaluationFournisseur.entities.Score;
import ma.emsi.evaluationFournisseur.mappers.ScoreMapper;
import ma.emsi.evaluationFournisseur.repositories.EvaluationRepo;
import ma.emsi.evaluationFournisseur.repositories.ProjectRepo;
import ma.emsi.evaluationFournisseur.repositories.QuestionRepo;
import ma.emsi.evaluationFournisseur.repositories.ScoreRepo;
import ma.emsi.evaluationFournisseur.services.EvaluationService;
import ma.emsi.evaluationFournisseur.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin("*")
public class EvaluationController {
    @Autowired
    EvaluationService evaluationService ;
    @Autowired
    SupplierService supplierService ;
    @Autowired
    ProjectRepo projectRepo ;
    @Autowired
    ScoreRepo scoreRepo ;
    @Autowired
    QuestionRepo questionRepo ;
    @Autowired
    EvaluationRepo evaluationRepo ;
    @Autowired
    ScoreMapper scoreMapper ;
//    @GetMapping("/evaluation/evaluation_score")
//    public Double getEvaluationScoreById(@RequestParam(name = "evaluationId" , defaultValue = "") Long evaluationId)
//    {
//        return evaluationService.getEvaluationScoreById(evaluationId) ;
//    }
//    @GetMapping("/evaluation/scores")
//    public List<ScoreDTO> getEvaluationScore(@RequestParam(name = "evaluationId" , defaultValue = "") Long evaluationId)
//    {
//        return evaluationService.getEvaluationScores(evaluationId) ;
//    }



//    @PostMapping("/evaluation")
//    public Long saveEvaluation(@RequestBody ProjectIdRequest projectIdRequest)
//    {
//        Evaluation evaluation = new Evaluation() ;
//        if (projectRepo.findById(projectIdRequest.getProjectId()).isPresent() && projectRepo.findById(projectIdRequest.getProjectId()).get().getEvaluation()==null){
//            Project project = projectRepo.findById(projectIdRequest.getProjectId()).get();
//            evaluation.setEvaluation_date(new Date());
//            projectRepo.save(project);
//            evaluation.setProject(project);
//            Evaluation savedEvaluation = evaluationService.saveEvaluation(evaluation);
//           return savedEvaluation.getId();
//        }
//        else
//        return null;
//    }
//    @PostMapping("/evaluation/new-score")
//    public ScoreDTO saveScore(@RequestBody ScoreDTO scoreDTO)
//    {
//        Score score = new Score() ;
//        score.setScore(scoreDTO.getScore());
//        if (questionRepo.findById(scoreDTO.getQuestion_id()).isPresent())
//        score.setQuestion(questionRepo.findById(scoreDTO.getQuestion_id()).get());
//        if (evaluationRepo.findById(scoreDTO.getEvaluation_id()).isPresent())
//            score.setEvaluation(evaluationRepo.findById(scoreDTO.getEvaluation_id()).get());
//        scoreRepo.save(score) ;
//        return scoreDTO ;
//    }
    @PostMapping("/evaluationV2")
    public EvaluationDTO saveEvaluation(@RequestBody EvaluationDTO evaluationDTO)
    {
        if (projectRepo.findById(evaluationDTO.getProject_id()).isPresent()&&projectRepo.findById(evaluationDTO.getProject_id()).get().getEvaluation()!=null) return null ;
        Evaluation evaluation = new Evaluation() ;
        evaluation.setEvaluation_score(evaluationDTO.getEvaluation_score());
        evaluation.setEvaluation_date(new Date());
        evaluation.setProject(projectRepo.findById(evaluationDTO.getProject_id()).isPresent()?projectRepo.findById(evaluationDTO.getProject_id()).get():null);
        List<Score> scores = new ArrayList<>() ;
        scores = evaluationDTO.getScores().stream().map(scoreDTOV2 -> scoreMapper.fromScoreDTO(scoreDTOV2)).collect(Collectors.toList()) ;
        evaluation.setEvaluation_score(calculateEvaluationScore(scores));
        Evaluation savedEvaluation = evaluationRepo.save(evaluation) ;
        scores.forEach(score -> score.setEvaluation(savedEvaluation));
        scoreRepo.saveAll(scores);
        evaluation.setScores(scores);
        evaluationRepo.save(evaluation) ;
        supplierService.updateSupplierRating(evaluation.getProject().getSupplier().getId(),evaluation.getEvaluation_score()) ;
        return evaluationDTO ;
    }
    @DeleteMapping("/evaluations/{id}")
    public void deleteEvaluation(@PathVariable Long id)
    {
        if (projectRepo.findById(id).isPresent())
        {
            Project project = projectRepo.findById(id).get() ;
            Long supplierId = project.getSupplier().getId() ;
            evaluationService.deleteEvaluation(id) ;
            supplierService.updateSupplierRating(supplierId,null);
        }

    }
    @GetMapping("/evaluations/{id}")
    public EvaluationDTO getEvaluationById(@PathVariable Long id)
    {
        return evaluationService.getEvaluationById(id) ;
    }

    private Double calculateEvaluationScore(List<Score> scores) {
        double evaluation_score = 0;
        for (Score score : scores) {
            evaluation_score = evaluation_score + score.getScore() * score.getQuestion().getWeight();
        }
        return evaluation_score;
    }


}
