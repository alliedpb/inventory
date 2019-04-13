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

    @RequestMapping("/category/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping("category/add/{categoryName}")
    public Long addCategory(@PathVariable String categoryName) {
        return categoryService.addCategory(categoryName);
    }

    @RequestMapping("category/edit/{id}/{categoryName}")
    public Long editCategory(@PathVariable final Long id,@PathVariable final String categoryName) {
        return categoryService.editCategory(id, categoryName);
    }

    @RequestMapping("/category/{categoryId}")
    public Category getCategory(@PathVariable final Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

}
