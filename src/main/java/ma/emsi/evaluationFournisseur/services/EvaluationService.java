package ma.emsi.evaluationFournisseur.services;

import ma.emsi.evaluationFournisseur.dtos.EvaluationDTO;
import ma.emsi.evaluationFournisseur.dtos.ScoreDTO1;
import ma.emsi.evaluationFournisseur.entities.Evaluation;

import java.util.List;

public interface EvaluationService {
//    Double getEvaluationScoreById(Long evaluationId);
//    List<ScoreDTO1> getEvaluationScores(Long evaluationId) ;

    Evaluation saveEvaluation(Evaluation evaluation);

    void deleteEvaluation(Long id);

    EvaluationDTO getEvaluationById(Long evaluationId);
}
