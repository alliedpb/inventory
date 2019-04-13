package com.apb.inventory.service;

import com.apb.inventory.configuration.Config;
import com.apb.inventory.model.Category;
import com.apb.inventory.model.Supplier;
import com.apb.inventory.repository.CategoryRepository;
import com.apb.inventory.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service("inventorySupplierService")
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private Config config;

    @Override
    public Long addSupplier(String supplierName) {

        Supplier supplier = new Supplier();

        supplier.setSupplierName(supplierName);
        supplier.setDeletedFlag("N");
        supplier.setCreatedDate(LocalDate.now());
        supplier.setModifiedDate(supplier.getCreatedDate());
        supplier.setModifiedBy(config.getCurrentUser());

        supplierRepository.save(supplier);

        return supplier.getId();
    }

    @Override
    public Long editSupplier(Long id, String supplierName) {
        Supplier supplier = supplierRepository.findById(id).get();

        supplier.setSupplierName(supplierName);
        supplier.setModifiedDate(supplier.getCreatedDate());
        supplier.setModifiedBy(config.getCurrentUser());

        supplierRepository.save(supplier);

        return supplier.getId();
    }

    @Override
    public void deleteSupplier(Long id) {
        Supplier supplier = supplierRepository.findById(id).get();

        supplier.setDeletedFlag("Y");
        supplier.setModifiedDate(supplier.getCreatedDate());
        supplier.setModifiedBy(config.getCurrentUser());

        supplierRepository.save(supplier);


    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.getAll();
    }
}
