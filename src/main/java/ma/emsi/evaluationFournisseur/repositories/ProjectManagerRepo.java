package ma.emsi.evaluationFournisseur.repositories;

import ma.emsi.evaluationFournisseur.entities.Buyer;
import ma.emsi.evaluationFournisseur.entities.ProjectManager;
import org.apache.catalina.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectManagerRepo extends JpaRepository<ProjectManager,Long> {
    ProjectManager findByUserId(String userId) ;

}
