package com.apb.inventory.repository;

import com.apb.inventory.model.Category;
import com.apb.inventory.model.Product;
import com.apb.inventory.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("inventorySupplierRepository")
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT s FROM Supplier s WHERE s.deletedFlag = 'N'")
    public List<Supplier> getAll();
}
