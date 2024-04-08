package ma.emsi.evaluationFournisseur.services;

import ma.emsi.evaluationFournisseur.dtos.QuestionDTO;
import ma.emsi.evaluationFournisseur.mappers.QuestionMapper;
import ma.emsi.evaluationFournisseur.repositories.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    QuestionRepo questionRepo ;
    @Autowired
    QuestionMapper questionMapper ;
    @Override
    public List<QuestionDTO> getAllQuestions() {
        return questionRepo.findAll().stream().map(question -> questionMapper.fromQuestion(question)).collect(Collectors.toList());
    }
}
