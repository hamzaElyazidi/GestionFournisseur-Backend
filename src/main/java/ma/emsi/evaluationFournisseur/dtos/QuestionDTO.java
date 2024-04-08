package ma.emsi.evaluationFournisseur.dtos;

import lombok.Data;

@Data
public class QuestionDTO {
    private Long id ;
    private String text ;
    private Double weight ;
}
