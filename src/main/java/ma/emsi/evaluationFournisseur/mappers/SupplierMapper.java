package ma.emsi.evaluationFournisseur.mappers;

import ma.emsi.evaluationFournisseur.dtos.SupplierDTO;
import ma.emsi.evaluationFournisseur.entities.Supplier;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SupplierMapper {
    public SupplierDTO fromSupplier(Supplier supplier)
    {
        SupplierDTO supplierDTO = new SupplierDTO() ;
        supplierDTO.setId(supplier.getId());
        supplierDTO.setName(supplier.getName());
        supplierDTO.setDescription(supplier.getDescription());
        supplierDTO.setRating(supplier.getRating());
        supplierDTO.setNumber_of_projects(supplier.getProjects()==null?0:supplier.getProjects().size());
        supplierDTO.setSector(supplier.getSector());
        supplierDTO.setMail(supplier.getMail());
        supplierDTO.setPhone(supplier.getPhone());
        supplierDTO.setWebsite(supplier.getWebsite());
        return supplierDTO ;
    }
    public  Supplier fromSupplierDTO(SupplierDTO supplierDTO)
    {
        Supplier supplier = new Supplier() ;
        BeanUtils.copyProperties(supplierDTO,supplier);
        supplier.setProjects(null);
        return supplier ;
    }
}
