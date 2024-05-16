package ma.emsi.evaluationFournisseur.mappers;

import ma.emsi.evaluationFournisseur.dtos.ProjectDTO;
import ma.emsi.evaluationFournisseur.entities.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectMapper {
    public ProjectDTO fromProject(Project project)
    {
        ProjectDTO projectDTO = new ProjectDTO() ;
        projectDTO.setId(project.getId());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setEndsAt(project.getEndsAt());
        projectDTO.setStartsAt(project.getStartsAt());
        projectDTO.setN_contract(project.getN_contract());
        projectDTO.setProjectManagerId(project.getProjectManager()==null?null:project.getProjectManager().getId());
        projectDTO.setSupplierId(project.getSupplier().getId());
        projectDTO.setProjectManagerName(project.getProjectManager()==null?null:project.getProjectManager().getFirst_name()+" " +project.getProjectManager().getLast_name());
        projectDTO.setSupplierName(project.getSupplier().getName());
        projectDTO.setBuyerId(project.getBuyer()==null?null:project.getBuyer().getId());
        projectDTO.setBuyerName(project.getBuyer()==null?null:project.getBuyer().getFirst_name()+" " +project.getBuyer().getLast_name());
        projectDTO.setEvaluationId(project.getEvaluation()==null?null:project.getEvaluation().getId());
        projectDTO.setEvaluation_score(project.getEvaluation()==null?null:project.getEvaluation().getEvaluation_score());
        projectDTO.setEvaluation_date(project.getEvaluation()==null?null:project.getEvaluation().getEvaluation_date());
        projectDTO.setUserId(project.getProjectManager()==null?null:project.getProjectManager().getUserId());
        projectDTO.setAmount(project.getAmount());
        return projectDTO ;
    }
}
