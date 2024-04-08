package ma.emsi.evaluationFournisseur.repositories;

import ma.emsi.evaluationFournisseur.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepo extends JpaRepository<Score,Long> {
    public List<Score> findByEvaluationId(Long EvaluationId) ;
}
