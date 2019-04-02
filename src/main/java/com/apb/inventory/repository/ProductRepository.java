package com.apb.inventory.repository;

import com.apb.inventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("inventoryProductRepository")
public interface ProductRepository extends JpaRepository<Product, Long>{


    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.category c WHERE p.deletedFlag = 'N'")
    public List<Product> getAll();

}
