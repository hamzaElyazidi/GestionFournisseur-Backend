package ma.emsi.evaluationFournisseur.mappers;

import ma.emsi.evaluationFournisseur.dtos.ManagerDTO;
import ma.emsi.evaluationFournisseur.entities.ProjectManager;
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
        return managerDTO ;
    }
}
