package com.apb.inventory.service;

import com.apb.inventory.configuration.Config;
import com.apb.inventory.model.Category;
import com.apb.inventory.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service("inventoryCategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Config config;

    @Override
    public Long addCategory(String categoryName) {
        Category category = new Category();

        category.setCategoryName(categoryName);
        category.setDeletedFlag("N");
        category.setCreatedDate(LocalDateTime.now());
        category.setModifiedDate(category.getCreatedDate());
        category.setModifiedBy(config.getCurrentUser());

        categoryRepository.save(category);

        return category.getId();
    }

    @Override
    public Long editCategory(Long id, String categoryName) {
        Category category = categoryRepository.findById(id).get();

        category.setCategoryName(categoryName);
        category.setModifiedDate(LocalDateTime.now());
        category.setModifiedBy(config.getCurrentUser());

        categoryRepository.save(category);

        return category.getId();

    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).get();

        category.setDeletedFlag("Y");
        category.setModifiedDate(LocalDateTime.now());
        category.setModifiedBy(config.getCurrentUser());

        categoryRepository.save(category);


    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAll();
    }
}
