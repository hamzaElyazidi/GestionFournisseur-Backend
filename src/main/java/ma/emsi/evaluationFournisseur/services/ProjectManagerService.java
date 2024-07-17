package ma.emsi.evaluationFournisseur.services;

import ma.emsi.evaluationFournisseur.dtos.BuyerDTO;
import ma.emsi.evaluationFournisseur.dtos.ManagerDTO;

import java.util.List;

public interface ProjectManagerService {
    List<ManagerDTO> getAllManagers() ;
    ManagerDTO getManagerByUserId(String userId);
    ManagerDTO saveManager(String userId , ManagerDTO managerDTO) ;

    BuyerDTO getBuyerByUserId(String userId);

    BuyerDTO saveBuyer(String userId, BuyerDTO buyerDTO);

    ManagerDTO getManagerById(Long id);

    List<BuyerDTO> getAllBuyers();

    void deleteProjectManagerById(Long id);
}
