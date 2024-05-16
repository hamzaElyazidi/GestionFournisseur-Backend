package ma.emsi.evaluationFournisseur.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String n_contract;
    @Lob
    @Column(columnDefinition = "BLOB")
    private String description ;
    private Date startsAt;
    private Date endsAt;
    private Double amount ;
    @ManyToOne
    private Supplier supplier ;
    @ManyToOne
    private ProjectManager projectManager ;
    @ManyToOne
    private Buyer buyer ;
    @OneToOne(mappedBy = "project" , cascade = CascadeType.REMOVE)
    private Evaluation evaluation ;
}
