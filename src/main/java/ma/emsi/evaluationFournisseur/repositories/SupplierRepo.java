package ma.emsi.evaluationFournisseur.repositories;

import ma.emsi.evaluationFournisseur.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepo extends JpaRepository<Supplier,Long> {
   List<Supplier> findByNameContains(String keyword) ;
   Supplier findByName(String name) ;
   List<Supplier> findByRatingGreaterThanEqual(Double minimumRating);
}
