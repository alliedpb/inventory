package com.apb.inventory.service;

import com.apb.inventory.model.Category;
import com.apb.inventory.model.Supplier;

import java.util.List;

public interface SupplierService {
    Long addSupplier(final String supplierName);
    Long editSupplier(final Long id, final String supplierName);
    void deleteSupplier(final Long id);
    List<Supplier> getAllSuppliers();
}
