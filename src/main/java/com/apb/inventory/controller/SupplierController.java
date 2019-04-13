package com.apb.inventory.controller;

import com.apb.inventory.model.Supplier;
import com.apb.inventory.repository.SupplierRepository;
import com.apb.inventory.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SupplierRepository supplierRepository;

    @RequestMapping("/supplier/all")
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @RequestMapping("supplier/add/{supplierName}")
    public Long addSupplier(@PathVariable String supplierName) {
        return supplierService.addSupplier(supplierName);
    }

    @RequestMapping("supplier/edit/{id}/{supplierName}")
    public Long editSupplier(@PathVariable final Long id,@PathVariable final String supplierName) {
        return supplierService.editSupplier(id, supplierName);
    }

    @RequestMapping("/supplier/{supplierId}")
    public Supplier getSupplier(@PathVariable final Long supplierId) {
        return supplierRepository.findById(supplierId).get();
    }

}
