package ma.emsi.evaluationFournisseur.mappers;

import ma.emsi.evaluationFournisseur.dtos.QuestionDTO;
import ma.emsi.evaluationFournisseur.entities.Question;
import org.springframework.stereotype.Service;

@Service
public class QuestionMapper {
    public QuestionDTO fromQuestion(Question question)
    {
        QuestionDTO questionDTO = new QuestionDTO() ;
        questionDTO.setId(question.getId());
        questionDTO.setText(question.getText());
        questionDTO.setWeight(question.getWeight());
        return questionDTO ;
    }
}
