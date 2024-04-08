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
    private String description ;
    private Date startsAt;
    private Date endsAt;
    @ManyToOne
    private Supplier supplier ;
    @ManyToOne
    private ProjectManager projectManager ;
    @OneToOne(mappedBy = "project" , cascade = CascadeType.REMOVE)
    private Evaluation evaluation ;
}
