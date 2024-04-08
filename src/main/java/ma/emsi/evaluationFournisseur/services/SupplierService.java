package ma.emsi.evaluationFournisseur.services;

import ma.emsi.evaluationFournisseur.dtos.SupplierDTO;

import java.util.List;

public interface SupplierService {
    List<SupplierDTO> getAllSuppliers();
    SupplierDTO getSupplierById(Long id);
    SupplierDTO saveSupplier(SupplierDTO supplierDTO) ;
    void deleteSupplier(Long supplierId) ;
    SupplierDTO updateSupplier(SupplierDTO supplierDTO) ;

    List<SupplierDTO> searchSuppliers(String keyword);

    void updateSupplierRating(Long projectId, Double evaluationScore);

    List<SupplierDTO> filterSupplierByMinRating(Double minRating);
}
