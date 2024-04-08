package ma.emsi.evaluationFournisseur.dtos;

import lombok.Data;

@Data
public class ScoreDTO1 {
    private Long id ;
    private Long question_id ;
    private Long evaluation_id ;
    private String question ;
    private Double question_weight ;
    private Double score ;

}
