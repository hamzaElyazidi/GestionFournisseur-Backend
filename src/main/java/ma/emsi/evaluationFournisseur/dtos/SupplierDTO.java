package ma.emsi.evaluationFournisseur.dtos;

import lombok.Data;
import ma.emsi.evaluationFournisseur.enums.industrySector;

@Data
public class SupplierDTO {
    private long id ;
    private String name ;
    private String description ;
    private double rating ;
    private long number_of_projects ;
    private String website ;
    private String phone ;
    private String email ;
    private industrySector sector ;
}
