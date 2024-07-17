package ma.emsi.evaluationFournisseur.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.evaluationFournisseur.dtos.BuyerDTO;
import ma.emsi.evaluationFournisseur.dtos.ManagerDTO;
import ma.emsi.evaluationFournisseur.entities.Buyer;
import ma.emsi.evaluationFournisseur.mappers.ProjectManagerMapper;
import ma.emsi.evaluationFournisseur.repositories.ProjectManagerRepo;
import ma.emsi.evaluationFournisseur.services.KeycloakService;
import ma.emsi.evaluationFournisseur.services.ProjectManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
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

    @GetMapping("/allBuyers")
    public List<BuyerDTO> getAllBuyers(){
        System.out.println("HERE");
        return projectManagerService.getAllBuyers() ;}

    @GetMapping("/managers")
    public ManagerDTO getManagerByUserId(@RequestParam(name = "userId" , defaultValue = "") String userId)
    {
        System.out.println("HERE!!!!!!!!!!!!!!!!!!!! USER ID : " + userId);
     return projectManagerService.getManagerByUserId(userId) ;
    }
    @GetMapping("/managers/{id}")
    public ManagerDTO getManagerById(@PathVariable Long id)
    {
        return projectManagerService.getManagerById(id) ;
    }
    @GetMapping("/buyers")
    public BuyerDTO getBuyerByUserId(@RequestParam(name = "userId" , defaultValue = "") String userId)
    {
        System.out.println("HERE!!!!!!!!!!!!!!!!!!!!");
        return projectManagerService.getBuyerByUserId(userId) ;
    }
    @PostMapping("/managers")
    public ResponseEntity<ManagerDTO> createManager(@RequestBody ManagerDTO managerDTO)
    {
        String userId = null;
        try {
            userId = keycloakService.createUser(managerDTO.getUsername(),managerDTO.getPassword(), managerDTO.getFirst_name(),managerDTO.getLast_name(),managerDTO.getEmail(),false);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
        ManagerDTO createdManager = projectManagerService.saveManager(userId,managerDTO);
        return ResponseEntity.ok(createdManager);
    }
    @PostMapping("/buyers")
    public ResponseEntity<BuyerDTO> createBuyer(@RequestBody BuyerDTO buyerDTO)
    {
        String userId = null;
        try {
            userId = keycloakService.createUser(buyerDTO.getUsername(),buyerDTO.getPassword(), buyerDTO.getFirst_name(),buyerDTO.getLast_name(),buyerDTO.getEmail(),true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
        BuyerDTO createdBuyer = projectManagerService.saveBuyer(userId,buyerDTO);
        return ResponseEntity.ok(createdBuyer);
    }
    @DeleteMapping("/managers/{id}")
    public void deleteProjectManager(@PathVariable Long id)
    {
        projectManagerService.deleteProjectManagerById(id) ;
    }



}
