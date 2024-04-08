package ma.emsi.evaluationFournisseur.mappers;

import ma.emsi.evaluationFournisseur.dtos.ScoreDTO1;
import ma.emsi.evaluationFournisseur.dtos.ScoreDTO;
import ma.emsi.evaluationFournisseur.entities.Score;
import ma.emsi.evaluationFournisseur.repositories.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreMapper {
    @Autowired
    QuestionRepo questionRepo ;
//    public ScoreDTO1 fromScore(Score score)
//    {
//        ScoreDTO1 scoreDTO = new ScoreDTO1() ;
//        scoreDTO.setId(score.getId());
//        scoreDTO.setScore(score.getScore());
//        scoreDTO.setQuestion_id(score.getQuestion()==null?null: score.getQuestion().getId());
//        scoreDTO.setQuestion(score.getQuestion()==null?null: score.getQuestion().getText());
//        scoreDTO.setQuestion_weight(score.getQuestion()==null?null:score.getQuestion().getWeight());
//        scoreDTO.setEvaluation_id(score.getEvaluation()==null?null:score.getEvaluation().getId());
//        return scoreDTO ;
//    }
    public ScoreDTO fromScore(Score score)
    {
        ScoreDTO scoreDTO = new ScoreDTO() ;
        scoreDTO.setId(score.getId());
        scoreDTO.setQuestion_id(score.getQuestion()==null?null:score.getQuestion().getId());
        scoreDTO.setScore(score.getScore());
        return scoreDTO ;
    }

    public Score fromScoreDTO(ScoreDTO scoreDTOV2) {
        Score score = new Score() ;
        score.setScore(scoreDTOV2.getScore());
        score.setQuestion(questionRepo.findById(scoreDTOV2.getQuestion_id()).isPresent()?questionRepo.findById(scoreDTOV2.getQuestion_id()).get():null);
        return score ;
    }
}
