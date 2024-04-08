package ma.emsi.evaluationFournisseur.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.evaluationFournisseur.dtos.ProjectDTO;
import ma.emsi.evaluationFournisseur.entities.Project;
import ma.emsi.evaluationFournisseur.repositories.ProjectRepo;
import ma.emsi.evaluationFournisseur.services.ProjectService;
import ma.emsi.evaluationFournisseur.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin("*")
public class ProjectController {
    @Autowired
    ProjectService projectService ;
    @Autowired
    SupplierService supplierService ;
    @Autowired
    ProjectRepo projectRepo ;
    @GetMapping("/projects")
    public List<ProjectDTO> getProjectsBySupplierId(@RequestParam(name = "supplierId" , defaultValue = "") Long supplierId)
    {
        return projectService.getProjectsBySupplierId(supplierId) ;
    }
    @PostMapping("/projects")
    public ProjectDTO saveProject(@RequestBody ProjectDTO projectDTO)
    {
        return projectService.saveProject(projectDTO) ;
    }
    @DeleteMapping("/projects/{id}")
    public void deleteProject(@PathVariable Long id){
        if (projectRepo.findById(id).isPresent())
        {
            Project project = projectRepo.findById(id).get() ;
            Long supplierId = project.getSupplier().getId() ;
            projectService.deleteProject(id);
            supplierService.updateSupplierRating(supplierId,null);
        }
    }
}
