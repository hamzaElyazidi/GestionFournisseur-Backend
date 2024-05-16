package ma.emsi.evaluationFournisseur.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.emsi.evaluationFournisseur.enums.industrySector;

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
    @Lob
    @Column(columnDefinition = "BLOB")
    private String description ;
    private Double rating;
    @Enumerated(EnumType.STRING)
    private industrySector sector ;
    private String website ;
    private String phone ;
    private String email ;
    @OneToMany(mappedBy = "supplier" , cascade = CascadeType.REMOVE , orphanRemoval = true)
    private List<Project> projects ;
}
