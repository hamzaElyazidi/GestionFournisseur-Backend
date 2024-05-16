package ma.emsi.evaluationFournisseur.dtos;

import lombok.Data;

@Data
public class BuyerDTO {
    private Long id ;
    private String first_name ;
    private String last_name;
    private String email ;
    private String username ;
    private String password ;
}
