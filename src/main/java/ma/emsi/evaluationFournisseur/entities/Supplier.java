package ma.emsi.evaluationFournisseur.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;
    private String description ;
    private Double rating;
    @OneToMany(mappedBy = "supplier" , cascade = CascadeType.REMOVE , orphanRemoval = true)
    private List<Project> projects ;
}
