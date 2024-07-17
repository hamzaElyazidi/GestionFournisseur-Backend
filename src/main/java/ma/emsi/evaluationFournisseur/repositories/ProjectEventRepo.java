package ma.emsi.evaluationFournisseur.repositories;

import ma.emsi.evaluationFournisseur.entities.Buyer;
import ma.emsi.evaluationFournisseur.entities.ProjectEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  ProjectEventRepo extends JpaRepository<ProjectEvent,Long> {
    List<ProjectEvent> findByProjectManagerId(Long projectManagerId) ;

}
