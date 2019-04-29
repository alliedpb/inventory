package com.apb.inventory.controller;

import com.apb.inventory.model.Category;
import com.apb.inventory.repository.CategoryRepository;
import com.apb.inventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/category/all", produces = "application/json")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "category/add/{categoryName}", produces = "application/json")
    public Long addCategory(@PathVariable String categoryName) {
        return categoryService.addCategory(categoryName);
    }

    @RequestMapping(value = "category/edit/{id}/{categoryName}", produces = "application/json")
    public Long editCategory(@PathVariable final Long id,@PathVariable final String categoryName) {
        return categoryService.editCategory(id, categoryName);
    }

    @RequestMapping(value = "/category/{categoryId}", produces = "application/json")
    public Category getCategory(@PathVariable final Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

}
