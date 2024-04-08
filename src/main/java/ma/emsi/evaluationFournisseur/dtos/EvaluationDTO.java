package ma.emsi.evaluationFournisseur.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EvaluationDTO {
    private Long id ;
    private Date evaluation_date;
    private List<ScoreDTO> scores ;
    private Long project_id ;
    private Double evaluation_score;
}
