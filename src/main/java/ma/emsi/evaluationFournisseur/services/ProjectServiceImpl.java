package ma.emsi.evaluationFournisseur.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.evaluationFournisseur.dtos.ProjectDTO;
import ma.emsi.evaluationFournisseur.entities.*;
import ma.emsi.evaluationFournisseur.mappers.ProjectMapper;
import ma.emsi.evaluationFournisseur.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    BuyeRepo buyeRepo ;

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
        project.setSupplier(getSupplierById(projectDTO.getSupplierId()));
        project.setEvaluation(null);
        project.setAmount(projectDTO.getAmount());
        project.setProjectManager(getProjectManagerById(projectDTO.getProjectManagerId()));
        project.setBuyer(getBuyerByUserId(projectDTO.getUserId()));
        Project p2 = projectRepository.save(project) ;
        return projectMapper.fromProject(p2) ;
    }

    private Buyer getBuyerByUserId(String userId) {
        return buyeRepo.findByUserId(userId) ;
    }

    private ProjectManager getProjectManagerById(Long managerId) {

        //return managerRepo.findByUserId(userId) ;
          return managerRepo.findById(managerId).orElse(null);
    }

    private Supplier getSupplierById(Long supplierId) {
        return supplierRepo.findById(supplierId).orElse(null) ;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll().stream().map(project -> projectMapper.fromProject(project)).collect(Collectors.toList());
    }
    @Override
    public List<ProjectDTO> getProjectsByUserId(String userId, String usertype) {
        if (usertype.equals("BUYER"))
        return projectRepository.findAll().stream().filter(project -> project.getBuyer()!=null).filter(project -> (project.getBuyer().getUserId().compareTo(userId))==0).map(project -> projectMapper.fromProject(project)).collect(Collectors.toList());
        if (usertype.equals("MANAGER"))
            return projectRepository.findAll().stream().filter(project -> project.getProjectManager()!=null).filter(project -> (project.getProjectManager().getUserId().compareTo(userId))==0).map(project -> projectMapper.fromProject(project)).collect(Collectors.toList());
        return null ;
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        if (projectRepository.findById(id).isPresent()) return projectMapper.fromProject(projectRepository.findById(id).get()) ;
        else return null ;
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
