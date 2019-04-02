package com.apb.inventory.repository;

import com.apb.inventory.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("inventoryCategoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
