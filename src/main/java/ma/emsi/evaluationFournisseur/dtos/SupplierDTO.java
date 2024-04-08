package ma.emsi.evaluationFournisseur.dtos;

import lombok.Data;

@Data
public class SupplierDTO {
    private long id ;
    private String name ;
    private String description ;
    private double rating ;
}
