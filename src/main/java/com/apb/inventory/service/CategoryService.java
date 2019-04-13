package com.apb.inventory.service;

import com.apb.inventory.model.Category;
import com.apb.inventory.model.Product;

import java.util.List;

public interface CategoryService {

    Long addCategory(final String categoryName);
    Long editCategory(final Long id, final String categoryName);
    void deleteCategory(final Long id);
    List<Category> getAllCategories();
}
