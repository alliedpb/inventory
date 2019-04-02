package com.apb.inventory.controller;

import com.apb.inventory.model.Category;
import com.apb.inventory.repository.CategoryRepository;
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
    private CategoryRepository categoryRepository;

    @RequestMapping("/category/all")
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @RequestMapping("category/add/{categoryName}")
    public Long addCategory(@PathVariable String categoryName) {

        Category category = new Category();
        category.setCategoryName(categoryName);

        categoryRepository.save(category);

        return category.getId();

    }

    @RequestMapping("category/edit/{id}/{categoryName}")
    public Long editCategory(@PathVariable final Long id,@PathVariable  final String categoryName) {

        Category category = categoryRepository.findById(id).get();
        category.setCategoryName(categoryName);
        categoryRepository.save(category);

        return category.getId();

    }

}
