package ma.emsi.evaluationFournisseur.repositories;

import ma.emsi.evaluationFournisseur.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project,Long> {
    List<Project> findBySupplierId(Long supplierId) ;
    Project findByevaluationId(Long evaluationId);
   // Project find
}
