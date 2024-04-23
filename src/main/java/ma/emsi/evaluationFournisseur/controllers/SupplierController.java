package ma.emsi.evaluationFournisseur.controllers;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.evaluationFournisseur.dtos.SupplierDTO;
import ma.emsi.evaluationFournisseur.entities.Supplier;
import ma.emsi.evaluationFournisseur.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin("*")

public class SupplierController {
    @Autowired
    SupplierService supplierService ;
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/suppliers")
    public List<SupplierDTO> suppliers() {
        return supplierService.getAllSuppliers();
    }
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/suppliers/search")
    public List<SupplierDTO> searchSupplier(@RequestParam(name = "keyword" , defaultValue = "") String keyword)
    {
        return supplierService.searchSuppliers(keyword) ;
    }
  //  @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/suppliers/filter")
    public List<SupplierDTO> filterSupplierByMinRating(@RequestParam(name = "minRating" , defaultValue = "0") Double minRating)
    {
        return supplierService.filterSupplierByMinRating(minRating) ;
    }
    @PostMapping("/suppliers")
 //  @PreAuthorize("hasAuthority('ADMIN')")
    public SupplierDTO saveSupplier(@RequestBody SupplierDTO supplierDTO)
    {
        return supplierService.saveSupplier(supplierDTO) ;
    }
    @DeleteMapping("/suppliers/{id}")
 //  @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteSupplier(@PathVariable Long id){supplierService.deleteSupplier(id);}
    @GetMapping("/suppliers/{id}")
 //  @PreAuthorize("hasAuthority('USER')")
    public SupplierDTO getSupplierById(@PathVariable Long id){return supplierService.getSupplierById(id);}
    @PutMapping("/suppliers")
 //   @PreAuthorize("hasAuthority('ADMIN')")
    public SupplierDTO updateSupplier(@RequestBody SupplierDTO supplierDTO)
    {
        return supplierService.updateSupplier(supplierDTO);
    }
}
