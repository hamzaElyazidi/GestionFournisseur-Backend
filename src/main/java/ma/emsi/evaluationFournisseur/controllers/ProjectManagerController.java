package ma.emsi.evaluationFournisseur.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.evaluationFournisseur.dtos.BuyerDTO;
import ma.emsi.evaluationFournisseur.dtos.ManagerDTO;
import ma.emsi.evaluationFournisseur.mappers.ProjectManagerMapper;
import ma.emsi.evaluationFournisseur.repositories.ProjectManagerRepo;
import ma.emsi.evaluationFournisseur.services.KeycloakService;
import ma.emsi.evaluationFournisseur.services.ProjectManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin("*")
public class ProjectManagerController {
    @Autowired
    ProjectManagerService projectManagerService ;
    @Autowired
    KeycloakService keycloakService ;
    @Autowired
    ProjectManagerMapper managerMapper ;

    @GetMapping("/allManagers")
    public List<ManagerDTO> getAllManagers(){
        System.out.println("HERE");
        return projectManagerService.getAllManagers() ;}
    @GetMapping("/managers")
    public ManagerDTO getManagerByUserId(@RequestParam(name = "userId" , defaultValue = "") String userId)
    {
        System.out.println("HERE!!!!!!!!!!!!!!!!!!!!");
     return projectManagerService.getManagerByUserId(userId) ;
    }
    @GetMapping("/buyers")
    public BuyerDTO getBuyerByUserId(@RequestParam(name = "userId" , defaultValue = "") String userId)
    {
        System.out.println("HERE!!!!!!!!!!!!!!!!!!!!");
        return projectManagerService.getBuyerByUserId(userId) ;
    }
    @PostMapping("/managers")
    public ManagerDTO createManager(@RequestBody ManagerDTO managerDTO)
    {
        System.out.println(managerDTO);
        String username = managerDTO.getUsername() ;
        System.out.println(managerDTO);
       String userId = keycloakService.createUser(managerDTO.getUsername(),managerDTO.getPassword(), managerDTO.getFirst_name(),managerDTO.getLast_name(),managerDTO.getEmail()) ;
       projectManagerService.saveManager(userId,managerDTO);
        return null ;
    }
}
