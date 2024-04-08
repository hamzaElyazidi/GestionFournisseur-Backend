package ma.emsi.evaluationFournisseur.services;

import ma.emsi.evaluationFournisseur.dtos.ProjectDTO;
import ma.emsi.evaluationFournisseur.entities.ProjectManager;
import ma.emsi.evaluationFournisseur.entities.Supplier;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> getProjectsBySupplierId(Long supplierId);

    Supplier getSupplierByName(String supplierName);

    ProjectManager getProjectManagerByFirstAndLastName(String projectManagerName);

    ProjectDTO saveProject(ProjectDTO projectDTO);

    List<ProjectDTO> getAllProjects();

    void deleteProject(Long id);
}
