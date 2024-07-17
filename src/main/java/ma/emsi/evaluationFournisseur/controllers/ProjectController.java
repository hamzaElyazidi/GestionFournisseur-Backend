package ma.emsi.evaluationFournisseur.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.evaluationFournisseur.dtos.ProjectDTO;
import ma.emsi.evaluationFournisseur.dtos.SupplierDTO;
import ma.emsi.evaluationFournisseur.entities.Project;
import ma.emsi.evaluationFournisseur.entities.ProjectEvent;
import ma.emsi.evaluationFournisseur.repositories.ProjectEventRepo;
import ma.emsi.evaluationFournisseur.repositories.ProjectRepo;
import ma.emsi.evaluationFournisseur.services.ProjectService;
import ma.emsi.evaluationFournisseur.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
    @Autowired
    ProjectEventRepo projectEventRepo ;

    @Autowired
    private StreamBridge streamBridge ;

    @GetMapping("/projects")
    public List<ProjectDTO> getProjectsBySupplierId(@RequestParam(name = "supplierId" , defaultValue = "") Long supplierId)
    {
        return projectService.getProjectsBySupplierId(supplierId) ;
    }
    @GetMapping("/projects/my-projects")
     public List<ProjectDTO> getProjectsByUserId(@RequestParam(name = "userId" , defaultValue = "") String userId ,@RequestParam(name = "usertype" , defaultValue = "") String usertype)
    {
        return projectService.getProjectsByUserId(userId,usertype) ;
    }
    @GetMapping("/projects/{id}")
    public ProjectDTO getProjectById(@PathVariable Long id)
    {
        return projectService.getProjectById(id) ;
    }
    @GetMapping("/projectEvents/{id}")
    public List<ProjectEvent> getProjectEventsByMangerId(@PathVariable Long id)
    {
        projectService.getProjectEventsByManagerId(id).forEach(System.out::println);
        return projectService.getProjectEventsByManagerId(id) ;
    }


    @PostMapping("/projects")
    public ResponseEntity<ProjectDTO> saveProject(@RequestBody ProjectDTO projectDTO)
    {
        ProjectDTO createdProjectDTO =  projectService.saveProject(projectDTO) ;
        saveProjectEvent(createdProjectDTO) ;
        sendNotification(projectDTO.getProjectManagerId(),createdProjectDTO);
        return ResponseEntity.ok(createdProjectDTO);
    }

    private void saveProjectEvent(ProjectDTO projectDTO) {
        ProjectEvent projectEvent = new ProjectEvent() ;
        projectEvent.setProjectId(projectDTO.getId());
        projectEvent.setN_contract(projectDTO.getN_contract());
        projectEvent.setBuyerName(projectDTO.getBuyerName());
        projectEvent.setProjectManagerId(projectDTO.getProjectManagerId());
        System.out.println(projectEventRepo.save(projectEvent) );
    }

    public void sendNotification(Long projectManagerId , ProjectDTO projectDTO)
    {
        String topic = "R1";
        streamBridge.send(topic , new ProjectEvent(1L,projectDTO.getN_contract() , projectDTO.getId(), projectDTO.getBuyerName(),projectManagerId)) ;
    }
    @PutMapping("/projects/update_dates")
    public void updateProjectDates(@RequestBody ProjectDTO projectDTO)
    {
        projectService.updateProjectDates(projectDTO) ;
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
    @DeleteMapping("/projectEvents/{id}")
    public void deleteProjectEvents(@PathVariable Long id){
        if (projectEventRepo.findById(id).isPresent())
        {
            projectEventRepo.deleteById(id);
        }
    }
    @PutMapping("/projects")
    //   @PreAuthorize("hasAuthority('ADMIN')")
    public ProjectDTO updateProject(@RequestBody ProjectDTO projectDTO)
    {
        System.out.println("RE : " + projectDTO);
        return  projectService.updateProject(projectDTO) ;
    }


}
