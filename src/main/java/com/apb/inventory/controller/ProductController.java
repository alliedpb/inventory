package com.apb.inventory.controller;

import com.apb.inventory.model.Product;
import com.apb.inventory.repository.ProductRepository;
import com.apb.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/product/{id}", produces = "application/json")
    public Product getProductById(@PathVariable("id") final Long productId) {
        return productRepository.findById(productId).get();
    }

    @RequestMapping(value = "/product/all", produces = "application/json")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @RequestMapping(value = "/product/add/{productNumber}/{productName}/{productDesc}/{categoryId}/{minInventory}/{startingInventory}", produces = "application/json")
    public Long addProduct(@PathVariable final String productNumber,
                                 @PathVariable final String productName,
                                 @PathVariable final String productDesc,
                                 @PathVariable final Long categoryId,
                                 @PathVariable final Long minInventory,
                                 @PathVariable final Long startingInventory) {

        return productService.addProduct(productNumber, productName, productDesc, categoryId, minInventory, startingInventory);

    }


    @RequestMapping(value = "/product/edit/{id}/{productNumber}/{productName}/{productDesc}/{categoryId}/{minimumRequired}/{startingInventory}", produces = "application/json")
    public Long editProduct(@PathVariable final Long id,
                            @PathVariable final String productNumber,
                            @PathVariable final String productName,
                            @PathVariable final String productDesc,
                            @PathVariable final Long categoryId,
                            @PathVariable final Long minimumRequired,
                            @PathVariable final Long startingInventory) {

        return productService.editProduct(id, productNumber, productName, productDesc, categoryId, minimumRequired, startingInventory);

    }

    @RequestMapping(value = "/product/delete/{id}", produces = "application/json")
    public void deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
    }



}


