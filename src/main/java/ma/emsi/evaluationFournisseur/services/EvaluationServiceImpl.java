package ma.emsi.evaluationFournisseur.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.evaluationFournisseur.dtos.EvaluationDTO;
import ma.emsi.evaluationFournisseur.dtos.ScoreDTO1;
import ma.emsi.evaluationFournisseur.entities.Evaluation;
import ma.emsi.evaluationFournisseur.entities.Project;
import ma.emsi.evaluationFournisseur.mappers.EvaluationMapper;
import ma.emsi.evaluationFournisseur.mappers.ScoreMapper;
import ma.emsi.evaluationFournisseur.repositories.EvaluationRepo;
import ma.emsi.evaluationFournisseur.repositories.ProjectRepo;
import ma.emsi.evaluationFournisseur.repositories.ScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class EvaluationServiceImpl implements EvaluationService{
    @Autowired
    EvaluationRepo evaluationRepo ;
    @Autowired
    SupplierService supplierService ;
    @Autowired
    ProjectRepo projectRepo ;
    @Autowired
    ScoreRepo scoreRepo ;
    @Autowired
    ScoreMapper scoreMapper ;
    @Autowired
    ProjectService projectService ;
    @Autowired
    EvaluationMapper evaluationMapper ;
//    @Override
//    public Double getEvaluationScoreById(Long evaluationId) {
//        if(evaluationRepo.findById(evaluationId).isEmpty())return null;
//        else return evaluationRepo.findById(evaluationId).get().getEvaluation_score() ;
//    }
//    @Override
//    public List<ScoreDTO1> getEvaluationScores(Long evaluationId) {
//        if(evaluationRepo.findById(evaluationId).isEmpty())return null;
//        else return scoreRepo.findByEvaluationId(evaluationId).stream().map(score -> scoreMapper.fromScore(score)).toList() ;
//    }
    @Override
    public Evaluation saveEvaluation(Evaluation evaluation) {
        return evaluationRepo.save(evaluation);
    }

    @Override
    public void deleteEvaluation(Long projectId) {
        if (projectRepo.findById(projectId).isEmpty()) return;
        Project project = projectRepo.findById(projectId).get() ;
        if (project.getEvaluation()==null)return;
        evaluationRepo.deleteById(project.getEvaluation().getId());
        project.setEvaluation(null);
        projectRepo.save(project) ;
    }

    @Override
    public EvaluationDTO getEvaluationById(Long evaluationId) {
        if (evaluationRepo.findById(evaluationId).isEmpty()) return null;
        return evaluationMapper.fromEvaluation( evaluationRepo.findById(evaluationId).get() );
    }
}
