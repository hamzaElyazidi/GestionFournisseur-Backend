package ma.emsi.evaluationFournisseur.dtos;

import lombok.Data;

@Data
public class ScoreDTO {
    private Long id ;
    private Long question_id ;
    private Double score ;
}
