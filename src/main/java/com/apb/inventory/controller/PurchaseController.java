package com.apb.inventory.controller;

import com.apb.inventory.model.Purchase;
import com.apb.inventory.repository.PurchaseRepository;
import com.apb.inventory.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @RequestMapping(value = "/purchase/list/{purchaseDate}/{productId}/{supplierId}", produces = "application/json")
    public List<Purchase> getPurchases(@PathVariable @DateTimeFormat(pattern="yyyyMMdd") LocalDate purchaseDate, @PathVariable Long productId, @PathVariable Long supplierId) {
        return purchaseService.getPurchases(purchaseDate, productId, supplierId);
    }

    @RequestMapping(value = "/purchase/{id}", produces = "application/json")
    @GetMapping
    public Purchase getPurchase(@PathVariable Long id) {
        return purchaseRepository.findById(id).get();
    }

    @RequestMapping(value = "/purchase/add/{purchaseDate}/{productId}/{supplierId}/{purchaseQty}", produces = "application/json")
    public Long addPurchase(@PathVariable @DateTimeFormat(pattern="yyyyMMdd") LocalDate purchaseDate, @PathVariable Long productId, @PathVariable Long supplierId, @PathVariable Long purchaseQty ) {
        return purchaseService.addPurchase(purchaseDate,productId, supplierId, purchaseQty);
    }

    @RequestMapping(value = "/purchase/edit/{id}/{purchaseDate}/{supplierId}/{purchaseQty}", produces = "application/json")
    public Long editPurchase(@PathVariable Long id, @PathVariable @DateTimeFormat(pattern="yyyyMMdd") LocalDate purchaseDate, @PathVariable Long supplierId, @PathVariable Long purchaseQty ) {
        return purchaseService.editPurchase(id, purchaseDate, supplierId, purchaseQty);
    }

    @RequestMapping(value = "/purchase/delete/{id}", produces = "application/json")
    public void deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
    }

}
