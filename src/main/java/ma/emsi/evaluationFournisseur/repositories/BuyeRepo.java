package ma.emsi.evaluationFournisseur.repositories;

import ma.emsi.evaluationFournisseur.entities.Buyer;
import ma.emsi.evaluationFournisseur.entities.ProjectManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyeRepo extends JpaRepository<Buyer,Long> {
    Buyer findByUserId(String userId) ;

}
