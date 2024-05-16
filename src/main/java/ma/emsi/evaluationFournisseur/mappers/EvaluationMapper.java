package ma.emsi.evaluationFournisseur.mappers;

import ma.emsi.evaluationFournisseur.dtos.EvaluationDTO;
import ma.emsi.evaluationFournisseur.dtos.ScoreDTO;
import ma.emsi.evaluationFournisseur.entities.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluationMapper {
    @Autowired
    ScoreMapper scoreMapper ;
    public  EvaluationDTO fromEvaluation(Evaluation evaluation)
    {
        EvaluationDTO evaluationDTO = new EvaluationDTO() ;
        if (evaluation==null) return null ;
        evaluationDTO.setEvaluation_date(evaluation.getEvaluation_date());
        evaluationDTO.setEvaluation_score(evaluation.getEvaluation_score());
        evaluationDTO.setId(evaluation.getId());
        evaluationDTO.setProject_id(evaluation.getProject()==null?null:evaluation.getProject().getId());
        if (evaluation.getScores().isEmpty()) evaluationDTO.setScores(null);
        else {
            List<ScoreDTO> scoreDTOList = evaluation.getScores().stream().map(score -> scoreMapper.fromScore(score)).collect(Collectors.toList()) ;
            evaluationDTO.setScores(scoreDTOList);
        }
        return evaluationDTO ;
    }
}
