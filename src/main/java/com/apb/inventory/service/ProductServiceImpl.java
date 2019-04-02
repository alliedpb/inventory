package com.apb.inventory.service;

import com.apb.inventory.controller.ProductController;
import com.apb.inventory.exception.InvalidCategory;
import com.apb.inventory.model.Product;
import com.apb.inventory.repository.CategoryRepository;
import com.apb.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("inventoryProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Long addProduct(String partNumber, String productName, String productDesc, Long categoryId, Long startingInventory) {

        //Validate CategoryId
        if (!categoryRepository.findById(categoryId).isPresent()) throw new InvalidCategory();

        Product product = new Product();

        product.setPartNumber(partNumber);
        product.setProductName(productName);
        product.setProductDesc(productDesc);
        product.setCategoryId(categoryId);
        product.setStartingInventory(startingInventory);
        product.setInventoryOnHand(startingInventory);
        product.setDeletedFlag("N");

        productRepository.save(product);

        return product.getId();
    }

    @Override
    public Long editProduct(Long id, String partNumber, String productName, String productDesc, Long categoryId, Long startingInventory) {

        //Validate CategoryId
        if (!categoryRepository.findById(categoryId).isPresent()) throw new InvalidCategory();

        Product product = productRepository.getOne(id);

        product.setPartNumber(partNumber);
        product.setProductName(productName);
        product.setProductDesc(productDesc);
        product.setCategoryId(categoryId);
        product.setInventoryOnHand(startingInventory);

        productRepository.save(product);
        return product.getId();

    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.getOne(id);
        product.setDeletedFlag("Y");

        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }
}
