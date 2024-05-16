package ma.emsi.evaluationFournisseur.dtos;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;
import ma.emsi.evaluationFournisseur.entities.Evaluation;
import ma.emsi.evaluationFournisseur.entities.ProjectManager;
import ma.emsi.evaluationFournisseur.entities.Supplier;

import java.util.Date;
@Data
@ToString
public class ProjectDTO {
    private Long id;
    private String n_contract;
    private String description ;
    private Date startsAt;
    private Date endsAt;
    private Long supplierId ;
    private Long projectManagerId ;
    private String projectManagerName ;
    private Long buyerId ;
    private String buyerName ;
    private String supplierName ;
    private Long evaluationId ;
    private Double evaluation_score ;
    private Date evaluation_date ;
    private String userId ;
    private Double amount ;
}
