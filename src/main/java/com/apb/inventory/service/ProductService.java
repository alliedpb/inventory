package com.apb.inventory.service;


import com.apb.inventory.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {

    Long addProduct(final String productNumber, final String productName, final String productDesc, final Long categoryId, final Long minInventory, final Long startingInventory);
    Long editProduct(final Long id, final String productNumber, final String productName, final String productDesc, final Long categoryId, final Long minInventory, final Long startingInventory);
    void deleteProduct(final Long id);
    List<Product> getAllProducts();

}