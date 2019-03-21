package com.apb.inventory.controller;

import com.apb.inventory.model.Product;
import com.apb.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {


    @Autowired
    private ProductRepository stockRepository;

    @RequestMapping("/product/{partNumber}")
    public String getAllProducts(@PathVariable final String partNumber) {

        return String.format("You entered :%s", partNumber);
    }

    @RequestMapping("/product/all")
    public List<Product> getAllProducts() {
        return stockRepository.findAll();
    }
}
