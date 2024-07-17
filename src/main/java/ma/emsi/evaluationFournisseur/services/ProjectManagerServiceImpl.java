package ma.emsi.evaluationFournisseur.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.evaluationFournisseur.dtos.BuyerDTO;
import ma.emsi.evaluationFournisseur.dtos.ManagerDTO;
import ma.emsi.evaluationFournisseur.entities.Buyer;
import ma.emsi.evaluationFournisseur.entities.ProjectManager;
import ma.emsi.evaluationFournisseur.mappers.ProjectManagerMapper;
import ma.emsi.evaluationFournisseur.repositories.BuyeRepo;
import ma.emsi.evaluationFournisseur.repositories.ProjectManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional // operations transactionnels
@AllArgsConstructor
@Slf4j // annotation qui implemente attribut log
public class ProjectManagerServiceImpl implements ProjectManagerService {
    @Autowired
    ProjectManagerRepo projectManagerRepo ;
    @Autowired
    ProjectManagerMapper projectManagerMapper;
    @Autowired
    BuyeRepo buyeRepo ;

    @Override
    public List<ManagerDTO> getAllManagers() {
        return projectManagerRepo.findAll().stream().map(projectManager -> projectManagerMapper.fromManager(projectManager)).collect(Collectors.toList());
    }

    @Override
    public List<BuyerDTO> getAllBuyers() {
        return buyeRepo.findAll().stream().map(buyer -> projectManagerMapper.fromBuyer(buyer)).collect(Collectors.toList());
    }

    @Override
    public void deleteProjectManagerById(Long id) {

    }


    @Override
    public ManagerDTO getManagerByUserId(String userId) {
        System.out.println("MANAGER IN REPO : " + projectManagerRepo.findByUserId(userId).getFirst_name());
        return  projectManagerMapper.fromManager(projectManagerRepo.findByUserId(userId));
    }

    @Override
    public BuyerDTO getBuyerByUserId(String userId) {
        return projectManagerMapper.fromBuyer(buyeRepo.findByUserId(userId)) ;
    }

    @Override
    public BuyerDTO saveBuyer(String userId, BuyerDTO buyerDTO) {
        Buyer buyer = projectManagerMapper.fromBuyerDTO(buyerDTO) ;
        buyer.setUserId(userId);
        return projectManagerMapper.fromBuyer(buyeRepo.save(buyer)) ;
    }

    @Override
    public ManagerDTO getManagerById(Long id) {
        if (projectManagerRepo.findById(id).isPresent())
        return projectManagerMapper.fromManager(projectManagerRepo.findById(id).get()) ;
         return null ;
    }


    @Override
    public ManagerDTO saveManager(String userId , ManagerDTO managerDTO) {
        ProjectManager projectManager = projectManagerMapper.fromManagerDTO(managerDTO) ;
        projectManager.setUserId(userId);
        return projectManagerMapper.fromManager(projectManagerRepo.save(projectManager)) ;
    }



}
