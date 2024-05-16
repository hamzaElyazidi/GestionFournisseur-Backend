package ma.emsi.evaluationFournisseur.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name ;
    private String last_name ;
    private String email ;
    @OneToMany(mappedBy = "buyer" , fetch = FetchType.LAZY)
    private List<Project> projects ;
    private String userId ;
}
