package com.apb.inventory.repository;

import com.apb.inventory.model.Category;
import com.apb.inventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("inventoryCategoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.deletedFlag = 'N'")
    public List<Category> getAll();
}
