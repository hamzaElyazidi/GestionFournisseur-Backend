package ma.emsi.evaluationFournisseur.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date evaluation_date;
    @OneToMany(mappedBy = "evaluation" , cascade = CascadeType.REMOVE)
    private List<Score> scores  ;
    @OneToOne
    private Project project ;
    private Double evaluation_score;
}
