package ma.emsi.evaluationFournisseur.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.evaluationFournisseur.dtos.SupplierDTO;
import ma.emsi.evaluationFournisseur.entities.Project;
import ma.emsi.evaluationFournisseur.entities.Supplier;
import ma.emsi.evaluationFournisseur.mappers.SupplierMapper;
import ma.emsi.evaluationFournisseur.repositories.ProjectRepo;
import ma.emsi.evaluationFournisseur.repositories.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional // operations transactionnels
@AllArgsConstructor
@Slf4j // annotation qui implemente attribut log
public class SupplierServiceImpl implements SupplierService{
    @Autowired
    private SupplierRepo supplierRepository ;
    @Autowired
    private ProjectRepo projectRepository ;
    @Autowired
    private SupplierMapper supplierMapper ;
    @Override
    public List<SupplierDTO> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll() ;
        return suppliers.stream().map(supplier -> supplierMapper.fromSupplier(supplier)).collect(Collectors.toList());
    }
    @Override
    public SupplierDTO getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElse(null) ;
        System.out.println("mail : " + supplierRepository.findById(id).get().getMail());
        if (supplier != null )
            return supplierMapper.fromSupplier(supplier);
        return null ;
    }
    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = supplierMapper.fromSupplierDTO(supplierDTO) ;
        Supplier savedSupplier = supplierRepository.save(supplier) ;
        return supplierMapper.fromSupplier(savedSupplier);
    }
    @Override
    public void deleteSupplier(Long supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId).orElseThrow() ;
        List<Project> projects = supplier.getProjects() ;
        projectRepository.deleteAll(projects);
        supplierRepository.deleteById(supplierId);
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {
        System.out.println(supplierDTO);
        Supplier supplier = supplierRepository.findById(supplierDTO.getId()).orElseThrow() ;
        supplier.setName(supplierDTO.getName());
        supplier.setDescription(supplierDTO.getDescription());
        supplier.setMail(supplierDTO.getMail());
        supplier.setPhone(supplierDTO.getPhone());
        supplier.setWebsite(supplierDTO.getWebsite());
        supplier.setSector(supplierDTO.getSector());
        supplierRepository.save(supplier) ;
        return supplierMapper.fromSupplier(supplier);
    }
    @Override
    public List<SupplierDTO> searchSuppliers(String keyword) {
        List<Supplier> suppliers = supplierRepository.findByNameContains(keyword) ;
        return suppliers.stream().map(supplier -> supplierMapper.fromSupplier(supplier)).collect(Collectors.toList());
    }
    @Override
    public List<SupplierDTO> filterSupplierByMinRating(Double minRating) {
        List<Supplier> suppliers ;
        if (minRating==null)  supplierRepository.findByRatingGreaterThanEqual(0.);
       suppliers=  supplierRepository.findByRatingGreaterThanEqual(minRating);
        return suppliers.stream().map(supplier -> supplierMapper.fromSupplier(supplier)).collect(Collectors.toList());
    }
    @Override
    public void updateSupplierRating(Long supplierId, Double current_evaluationScore)
    {
        if (supplierRepository.findById(supplierId).isEmpty()) {return;}
        Supplier supplier = supplierRepository.findById(supplierId).get() ;
        List<Double> evaluations_scores = new ArrayList<>() ;
        if (current_evaluationScore!=null) evaluations_scores.add(current_evaluationScore) ;
      supplier.getProjects().stream()
                .filter(project -> project.getEvaluation()!=null)
                .map(project -> project.getEvaluation().getEvaluation_score())
              .forEach(evaluations_scores::add);
      Double rating = 0. ;
      if (!evaluations_scores.isEmpty()){
          rating = evaluations_scores.stream().mapToDouble(Double::doubleValue).average().getAsDouble() ;
      }
      supplier.setRating(rating);
      supplierRepository.save(supplier) ;
    }



}
