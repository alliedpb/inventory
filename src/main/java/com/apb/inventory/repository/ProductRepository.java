package com.apb.inventory.repository;

import com.apb.inventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("inventoryProductRepository")
public interface ProductRepository extends JpaRepository<Product, Long>{
}
