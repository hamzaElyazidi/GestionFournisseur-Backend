package ma.emsi.evaluationFournisseur.services;

import ma.emsi.evaluationFournisseur.dtos.BuyerDTO;
import ma.emsi.evaluationFournisseur.dtos.ManagerDTO;

import java.util.List;

public interface ProjectManagerService {
    List<ManagerDTO> getAllManagers() ;
    ManagerDTO getManagerByUserId(String userId);
    void saveManager(String userId , ManagerDTO managerDTO) ;

    BuyerDTO getBuyerByUserId(String userId);
}
