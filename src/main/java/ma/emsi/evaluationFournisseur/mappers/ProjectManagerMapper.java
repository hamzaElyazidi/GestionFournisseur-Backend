package ma.emsi.evaluationFournisseur.mappers;

import ma.emsi.evaluationFournisseur.dtos.BuyerDTO;
import ma.emsi.evaluationFournisseur.dtos.ManagerDTO;
import ma.emsi.evaluationFournisseur.entities.Buyer;
import ma.emsi.evaluationFournisseur.entities.ProjectManager;
import org.apache.catalina.Manager;
import org.springframework.stereotype.Service;

@Service
public class ProjectManagerMapper {
    public ManagerDTO fromManager(ProjectManager projectManager)
    {
        ManagerDTO managerDTO = new ManagerDTO() ;
        managerDTO.setId(projectManager.getId());
        managerDTO.setFirst_name(projectManager.getFirst_name());
        managerDTO.setLast_name(projectManager.getLast_name());
        managerDTO.setJob_title(projectManager.getJob_title());
        managerDTO.setEmail(projectManager.getEmail());
        return managerDTO ;
    }
   public ProjectManager fromManagerDTO(ManagerDTO managerDTO)
    {
        ProjectManager projectManager = new ProjectManager() ;
        projectManager.setProjects(null);
        projectManager.setEmail(managerDTO.getEmail());
        projectManager.setFirst_name(managerDTO.getFirst_name());
        projectManager.setLast_name(managerDTO.getLast_name());
        projectManager.setJob_title(managerDTO.getJob_title());
        projectManager.setUserId(null);
        return projectManager ;
    }
    public Buyer fromBuyerDTO(BuyerDTO buyerDTO) {
        Buyer buyer = new Buyer() ;
        buyer.setProjects(null);
        buyer.setEmail(buyerDTO.getEmail());
        buyer.setFirst_name(buyerDTO.getFirst_name());
        buyer.setLast_name(buyerDTO.getLast_name());
        buyer.setUserId(null);
        return buyer ;
    }
    public BuyerDTO fromBuyer(Buyer buyer) {
        BuyerDTO buyerDTO = new BuyerDTO() ;
        buyerDTO.setId(buyer.getId());
        buyerDTO.setFirst_name(buyer.getFirst_name());
        buyerDTO.setLast_name(buyer.getLast_name());
        buyerDTO.setEmail(buyer.getEmail());
        return buyerDTO ;
    }


}
