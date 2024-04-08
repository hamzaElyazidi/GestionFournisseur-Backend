package ma.emsi.evaluationFournisseur.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.evaluationFournisseur.dtos.ProjectDTO;
import ma.emsi.evaluationFournisseur.entities.Evaluation;
import ma.emsi.evaluationFournisseur.entities.Project;
import ma.emsi.evaluationFournisseur.entities.ProjectManager;
import ma.emsi.evaluationFournisseur.entities.Supplier;
import ma.emsi.evaluationFournisseur.mappers.ProjectMapper;
import ma.emsi.evaluationFournisseur.repositories.EvaluationRepo;
import ma.emsi.evaluationFournisseur.repositories.ProjectManagerRepo;
import ma.emsi.evaluationFournisseur.repositories.ProjectRepo;
import ma.emsi.evaluationFournisseur.repositories.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectRepo projectRepository ;
    @Autowired
    ProjectMapper projectMapper ;
    @Autowired
    SupplierRepo supplierRepo ;
    @Autowired
    ProjectManagerRepo managerRepo ;
    @Autowired
    EvaluationRepo evaluationRepo ;
    @Autowired
    SupplierService supplierService ;
    @Override
    public List<ProjectDTO> getProjectsBySupplierId(Long supplierId)
    {
        List<Project> projects ;
        if (supplierId==null)
         projects = projectRepository.findAll() ;
        else
         projects = projectRepository.findBySupplierId(supplierId) ;
        List<ProjectDTO> projectDTOS  = projects.stream().map(project -> projectMapper.fromProject(project)).toList();
        return projectDTOS ;
    }

    @Override
    public Supplier getSupplierByName(String supplierName) {
        return supplierRepo.findByName(supplierName);
    }

    @Override
    public ProjectManager getProjectManagerByFirstAndLastName(String projectManagerName) {
        return managerRepo.findAll().stream().filter(projectManager -> (projectManager.getFirst_name()+" "+projectManager.getLast_name()).equals(projectManagerName)).collect(Collectors.toList()).get(0);
    }

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO)
    {
        Project project = new Project() ;
        project.setN_contract(projectDTO.getN_contract());
        project.setDescription(projectDTO.getDescription());
        project.setStartsAt(projectDTO.getStartsAt());
        project.setEndsAt(projectDTO.getEndsAt());
        project.setSupplier(getSupplierByName(projectDTO.getSupplierName()));
        project.setEvaluation(null);
        project.setProjectManager(null);
        projectRepository.save(project) ;
        return projectDTO ;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll().stream().map(project -> projectMapper.fromProject(project)).collect(Collectors.toList());
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id).orElseThrow() ;
        Supplier supplier = project.getSupplier() ;
        projectRepository.deleteById(id);
        supplier.getProjects().remove(project) ;
        project.setSupplier(null);
        supplierRepo.save(supplier) ;
    }

}
