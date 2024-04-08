package ma.emsi.evaluationFournisseur.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.evaluationFournisseur.dtos.ManagerDTO;
import ma.emsi.evaluationFournisseur.dtos.ProjectDTO;
import ma.emsi.evaluationFournisseur.mappers.ProjectManagerMapper;
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

    @Override
    public List<ManagerDTO> getAllManagers() {
        return projectManagerRepo.findAll().stream().map(projectManager -> projectManagerMapper.fromManager(projectManager)).collect(Collectors.toList());
    }
}
