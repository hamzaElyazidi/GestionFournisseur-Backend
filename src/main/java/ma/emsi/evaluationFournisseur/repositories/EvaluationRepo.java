package ma.emsi.evaluationFournisseur.repositories;

import ma.emsi.evaluationFournisseur.entities.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EvaluationRepo extends JpaRepository<Evaluation,Long> {
    @Modifying
    @Query("DELETE FROM Evaluation WHERE project.id = ?1")
    void deleteByProjectId(Long projectId) ;
}
